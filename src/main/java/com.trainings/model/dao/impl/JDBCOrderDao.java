package com.trainings.model.dao.impl;

import com.trainings.constant.GlobalConstants;
import com.trainings.constant.SqlQuery;
import com.trainings.model.dao.OrderDao;
import com.trainings.model.dao.mapper.OrderMapper;
import com.trainings.model.dto.ManagerOrderDTO;
import com.trainings.model.dto.UserOrderDTO;
import com.trainings.model.entity.Order;
import com.trainings.model.entity.Status;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JDBCOrderDao implements OrderDao {
    private static final String COUNT_ROWS_COLUMN_NAME = "C";

    private Connection connection;
    private OrderMapper orderMapper = new OrderMapper();

    JDBCOrderDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean create(final Order order) {
        try (PreparedStatement ps = createNewOrderPrepareStatement(order)) {
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public Optional<Order> findById(Integer id) {
        Optional<Order> order = Optional.empty();
        String sqlQuery = SqlQuery.ORDER_GET_BY_ID;
        try (PreparedStatement ps = setOneIntPreparedStatement(id, sqlQuery);
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                order = Optional.ofNullable(orderMapper.extractOrderFromResultSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return order;
    }

    @Override
    public List<Order> findAll() {
        String sqlQuery = SqlQuery.ORDER_GET_ALL;
        List<Order> orders = new ArrayList<>();
        try (Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery(sqlQuery)) {
            while (rs.next()) {
                orders.add(orderMapper.extractOrderFromResultSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    @Override
    public List<Order> findConfirmInWorkMasterOrders(int idMaster) {
        String sqlQuery = SqlQuery.ORDER_GET_ALL_CONFIRM;
        List<Order> orders = new ArrayList<>();
        try (PreparedStatement ps = setOneIntPreparedStatement(idMaster, sqlQuery);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                orders.add(orderMapper.extractOrderFromResultSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }


    //TODO REFACTOR
    @Override
    public void archiveOldDoneOrders(LocalDateTime olderThanDate) {
        List<Order> orders = findOldOrders(olderThanDate);
        System.out.println(orders);
        try (PreparedStatement archiveStatement = connection.prepareStatement(SqlQuery.ORDER_ARCHIVE_ADD);
             PreparedStatement deleteStatement = connection.prepareStatement(SqlQuery.ORDER_DELETE)) {
            connection.setAutoCommit(false);

            for (Order order : orders) {
                int idWorker;
                LocalDateTime closeDate;
                if (order.getStatus().equals(Status.REFUSE)) {
                    idWorker = order.getIdManager();
                    closeDate = order.getConsiderationDate();
                } else {
                    idWorker = order.getIdMaster();
                    closeDate = order.getDoneDate();
                }
             /*   OrderArchive oa = new OrderArchive(order.getIdOrder(), order.getIdUser(), order.getIdServe(),
                        order.getStatus(), order.getPrice(), idWorker, closeDate);*/
                archiveStatement.setInt(1, order.getIdOrder());
                archiveStatement.setInt(2, order.getIdUser());
                archiveStatement.setInt(3, order.getIdServe());
                archiveStatement.setString(4, order.getStatus().name());
                archiveStatement.setBigDecimal(5, order.getPrice());
                archiveStatement.setInt(6, idWorker);
                archiveStatement.setTimestamp(7, Timestamp.valueOf(closeDate));
                archiveStatement.addBatch();
                deleteStatement.setInt(1, order.getIdOrder());
                deleteStatement.addBatch();
            }
            archiveStatement.executeBatch();
            deleteStatement.executeBatch();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getNumberOfOrderRows() {
        String sqlQuery = SqlQuery.ORDERS_GET_COUNT;
        int count = 0;
        try (Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery(sqlQuery)) {
            if (rs.next()) {
                count = rs.getInt(COUNT_ROWS_COLUMN_NAME);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    private List<Order> findOldOrders(LocalDateTime olderThanDate) {
        List<Order> orders = new ArrayList<>();
        try (PreparedStatement ps = oldOrdersPrepareStatement(olderThanDate);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                orders.add(orderMapper.extractOrderFromResultSet(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    @Override
    public boolean update(final Order order) {
        try (PreparedStatement ps = updateOrderPrepareStatement(order)) {
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    @Override
    public boolean delete(final Integer id) {
        return false;
    }

    @Override
    public List<UserOrderDTO> findUsersOrders(int idUser) {
        List<UserOrderDTO> orders = new ArrayList<>();
        String sqlQuery = SqlQuery.GET_ALL_USERS_ORDERS;
        try (PreparedStatement ps = setOneIntPreparedStatement(idUser, sqlQuery);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                orders.add(orderMapper.extractUserOrderDTOFromResultSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    @Override
    public List<ManagerOrderDTO> findNewManagersOrders(int currentPage) {
        String sqlQuery = SqlQuery.ORDER_GET_ALL_NEW_MANAGER_ORDERS;
        List<ManagerOrderDTO> orders = new ArrayList<>();


        try (PreparedStatement ps = setManagerOrdersPrepareStatement(currentPage, sqlQuery);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                orders.add(orderMapper.extractManagerOrderDTOFromResultSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;

    }

    private PreparedStatement setManagerOrdersPrepareStatement(int currentPage, String sqlQuery) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(sqlQuery);
        int limitStart = (currentPage-1) * GlobalConstants.MANAGER_ROWS_PER_PAGE;
        ps.setInt(1, limitStart);
        ps.setInt(2, GlobalConstants.MANAGER_ROWS_PER_PAGE);
        System.out.println(ps);
        return ps;
    }


    private PreparedStatement createNewOrderPrepareStatement(Order order) throws SQLException {
        String sqlQuery = SqlQuery.ORDER_CREATE;
        return setAllFieldsExceptIdPreparedStatement(order, sqlQuery);
    }

    private PreparedStatement updateOrderPrepareStatement(Order order) throws SQLException {
        String sqlQuery = SqlQuery.ORDER_UPDATE;
        PreparedStatement ps = setAllFieldsExceptIdPreparedStatement(order, sqlQuery);
        ps.setInt(11, order.getIdOrder());
        return ps;
    }

    private PreparedStatement oldOrdersPrepareStatement(LocalDateTime localDateTime) throws SQLException {
        String sqlQuery = SqlQuery.ORDER_GET_OLDER_THAN;
        PreparedStatement ps = connection.prepareStatement(sqlQuery);
        //done or refused day bigger than date
        prepareStatementSetDateOrNull(1, localDateTime, ps);
        prepareStatementSetDateOrNull(2, localDateTime, ps);
        return ps;
    }

    private PreparedStatement setAllFieldsExceptIdPreparedStatement(Order order, String sqlQuery) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(sqlQuery);
        ps.setInt(1, order.getIdUser());
        ps.setInt(2, order.getIdServe());
        ps.setString(3, order.getStatus().name());
        ps.setBigDecimal(4, order.getPrice());
        prepareStatementSetIdOrNull(5, order.getIdManager(), ps);
        prepareStatementSetDateOrNull(6, order.getConsiderationDate(), ps);
        ps.setString(7, order.getRefuseReason());
        prepareStatementSetIdOrNull(8, order.getIdMaster(), ps);
        prepareStatementSetDateOrNull(9, order.getInWorkDate(), ps);
        prepareStatementSetDateOrNull(10, order.getDoneDate(), ps);
        return ps;
    }


    private PreparedStatement setOneIntPreparedStatement(int id, String sqlQuery) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(sqlQuery);
        ps.setInt(1, id);
        return ps;
    }

    private void prepareStatementSetIdOrNull(int index, Integer id, PreparedStatement ps) throws SQLException {
        if (id == null) {
            ps.setNull(index, java.sql.Types.INTEGER);
        } else {
            ps.setInt(index, id);
        }
    }

    private void prepareStatementSetDateOrNull(int index, LocalDateTime date, PreparedStatement ps) throws SQLException {
        if (date == null) {
            ps.setNull(index, java.sql.Types.DATE);
        } else {
            ps.setTimestamp(index, Timestamp.valueOf(date));
        }
    }

    @Override
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
