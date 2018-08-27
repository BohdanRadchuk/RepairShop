package com.trainings.model.dao.impl;

import com.trainings.constant.SqlQuery;
import com.trainings.model.dao.OrderDao;
import com.trainings.model.dao.mapper.OrderMapper;
import com.trainings.model.dto.UserOrderDTO;
import com.trainings.model.entity.Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JDBCOrderDao implements OrderDao {
    private Connection connection;
    private OrderMapper orderMapper = new OrderMapper();


    public JDBCOrderDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean create(final Order order) {
        try (PreparedStatement ps = newOrderPrepareStatement(order)) {
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

        try (PreparedStatement ps = findByIDPrepareStatement(id);
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                order = Optional.ofNullable(orderMapper.extractFromResultSet(rs));
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
                orders.add(orderMapper.extractFromResultSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orders;
    }

    @Override
    public boolean update(final Order order) {
        return false;
    }

    @Override
    public boolean delete(final Integer id) {
        return false;
    }

    public List<UserOrderDTO> findUsersOrders(int idUser) {
        List<UserOrderDTO> orders = new ArrayList<>();
        try (PreparedStatement ps = UsersOrdersPrepareStatement(idUser);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                orders.add(orderMapper.extractUserOrderDTOFromResultSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orders;
    }


    private PreparedStatement newOrderPrepareStatement(Order order) throws SQLException {

        String sqlQuery = SqlQuery.ORDER_CREATE;
        PreparedStatement ps = connection.prepareStatement(sqlQuery);

       /* id_user, id_service, status, price, id_manager, " +
        "consideration_date, refuse_reason, id_master, in_work_date, done_date*/
        ps.setInt(1, order.getIdUser());
        ps.setInt(2, order.getIdServe());
        ps.setString(3, order.getStatus().name());
        ps.setBigDecimal(4, order.getPrice());
        prepareStatementSetIdManagerOrNull(order, ps, 5);
        prepareStatementSetConsiderationDateOrNull(order, ps, 6);
        ps.setString(7, order.getRefuseReason());
        prepareStatementSetIdMasterOrNull(order, ps, 8);
        prepareStatementSetInWorkDateOrNull(order, ps, 9);
        prepareStatementSetDoneDateOrNull(order, ps, 10);
        return ps;
    }

    private PreparedStatement findByIDPrepareStatement(int id) throws SQLException {
        String sqlQuery = SqlQuery.ORDER_GET_BY_ID;
        return getIntPreparedStatement(id, sqlQuery);
    }

    private PreparedStatement UsersOrdersPrepareStatement(int id) throws SQLException {
        String sqlQuery = SqlQuery.GET_ALL_USERS_ORDERS;
        return getIntPreparedStatement(id, sqlQuery);
    }

    private PreparedStatement getIntPreparedStatement(int id, String sqlQuery) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(sqlQuery);
        ps.setInt(1, id);
        return ps;
    }


    private void prepareStatementSetIdManagerOrNull(Order order, PreparedStatement ps, int index) throws SQLException {
        if (order.getIdManager() == null) {
            ps.setNull(index, java.sql.Types.INTEGER);
        } else {
            ps.setInt(index, order.getIdManager());
        }
    }

    private void prepareStatementSetIdMasterOrNull(Order order, PreparedStatement ps, int index) throws SQLException {
        if (order.getIdMaster() == null) {
            ps.setNull(index, java.sql.Types.INTEGER);
        } else {
            ps.setInt(index, order.getIdMaster());
        }
    }

    private void prepareStatementSetConsiderationDateOrNull(Order order, PreparedStatement ps, int index) throws SQLException {
        if (order.getConsiderationDate() == null) {
            ps.setNull(index, java.sql.Types.DATE);
        } else {
            ps.setTimestamp(index, Timestamp.valueOf(order.getConsiderationDate()));
        }
    }

    private void prepareStatementSetInWorkDateOrNull(Order order, PreparedStatement ps, int index) throws SQLException {
        if (order.getInWorkDate() == null) {
            ps.setNull(index, java.sql.Types.DATE);
        } else {
            ps.setTimestamp(index, Timestamp.valueOf(order.getInWorkDate()));
        }
    }

    private void prepareStatementSetDoneDateOrNull(Order order, PreparedStatement ps, int index) throws SQLException {
        if (order.getDoneDate() == null) {
            ps.setNull(index, java.sql.Types.DATE);
        } else {
            ps.setTimestamp(index, Timestamp.valueOf(order.getDoneDate()));
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
