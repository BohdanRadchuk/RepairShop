package com.trainings.model.dao.impl;

import com.trainings.constant.SqlQuery;
import com.trainings.model.dao.OrderDao;
import com.trainings.model.dao.mapper.OrderMapper;
import com.trainings.model.dto.ManagerOrderDTO;
import com.trainings.model.dto.UserOrderDTO;
import com.trainings.model.entity.Order;

import java.sql.*;
import java.time.LocalDateTime;
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
        try (PreparedStatement ps = updateOrderPrepareStatement(order)) {
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }


    }

    private PreparedStatement updateOrderPrepareStatement(Order order) throws SQLException {
        String sqlQuery = SqlQuery.ORDER_UPDATE;
        return setAllFieldsNotExceptIdPreparedStatement(order, sqlQuery) ;
    }
    private PreparedStatement createNewOrderPrepareStatement(Order order) throws SQLException {
        String sqlQuery = SqlQuery.ORDER_CREATE;
        PreparedStatement ps = setAllFieldsNotExceptIdPreparedStatement(order, sqlQuery);
        ps.setInt(order.getIdOrder(),11);
        return ps;
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

    @Override
    public List<ManagerOrderDTO> findNewCutOrders() {
        String sqlQuery = SqlQuery.ORDER_GET_ALL_NEW_MANAGER_ORDERS;
        List<ManagerOrderDTO> orders = new ArrayList<>();

        try (Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery(sqlQuery)) {

            while (rs.next()) {
                orders.add(orderMapper.extractManagerOrderDTOFromResultSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    private PreparedStatement setAllFieldsNotExceptIdPreparedStatement(Order order, String sqlQuery) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(sqlQuery);

        ps.setInt(1, order.getIdUser());
        ps.setInt(2, order.getIdServe());
        ps.setString(3, order.getStatus().name());
        ps.setBigDecimal(4, order.getPrice());
        prepareStatementSetIdOrNull(order.getIdManager(), ps, 5);
        prepareStatementSetDateOrNull(order.getConsiderationDate(), ps, 6);
        ps.setString(7, order.getRefuseReason());
        prepareStatementSetIdOrNull(order.getIdMaster(), ps, 8);
        prepareStatementSetDateOrNull(order.getInWorkDate(), ps, 9);
        prepareStatementSetDateOrNull(order.getDoneDate(), ps, 10);
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

    private void prepareStatementSetIdOrNull(Integer id, PreparedStatement ps, int index) throws SQLException {
        if (id == null) {
            ps.setNull(index, java.sql.Types.INTEGER);
        } else {
            ps.setInt(index, id);
        }
    }

    private void prepareStatementSetDateOrNull(LocalDateTime date, PreparedStatement ps, int index) throws SQLException {
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
