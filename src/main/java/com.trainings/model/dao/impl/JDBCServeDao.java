package com.trainings.model.dao.impl;

import com.trainings.constant.SqlQuery;
import com.trainings.model.dao.ServeDao;
import com.trainings.model.dao.mapper.ServiceMapper;
import com.trainings.model.entity.Serve;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JDBCServeDao implements ServeDao {
    private Connection connection;
    private ServiceMapper serviceMapper = new ServiceMapper();


    public JDBCServeDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean create(final Serve service) {
        try (PreparedStatement ps = newServicePrepareStatement(service)) {
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public Optional<Serve> findById(final Integer id) {
        Optional<Serve> service = Optional.empty();

        try (PreparedStatement ps = findByIDPrepareStatement(id);
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                service = Optional.ofNullable(serviceMapper.extractFromResultSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return service;

    }

    @Override
    public List<Serve> findAll() {
        String sqlQuery = SqlQuery.SERVICE_GET_ALL;
        List<Serve> services = new ArrayList<>();
        try (Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery(sqlQuery)) {
            while (rs.next()) {
                services.add(serviceMapper.extractFromResultSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return services;
    }

    @Override
    public boolean update(Serve service) {
        try (PreparedStatement ps = updateServicePrepareStatement(service)) {
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(Integer id) {
        try (PreparedStatement ps = deleteServicePrepareStatement(id)) {
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    private PreparedStatement findByIDPrepareStatement(int id) throws SQLException {
        String sqlQuery = SqlQuery.SERVICE_GET_BY_ID;
        PreparedStatement ps = connection.prepareStatement(sqlQuery);
        ps.setInt(1, id);
        return ps;
    }

    private PreparedStatement newServicePrepareStatement(Serve service) throws SQLException {
        String sqlQuery = SqlQuery.SERVICE_CREATE;
        PreparedStatement ps = connection.prepareStatement(sqlQuery);
        prepareStatementSetServiceWithoutId(service, ps);
        return ps;
    }

    private PreparedStatement updateServicePrepareStatement(Serve service) throws SQLException {
        String sqlQuery = SqlQuery.SERVICE_UPDATE;
        PreparedStatement ps = connection.prepareStatement(sqlQuery);
        prepareStatementSetServiceWithoutId(service, ps);
        ps.setInt(6, service.getIdServe());
        return ps;
    }

    private void prepareStatementSetServiceWithoutId(Serve service, PreparedStatement ps) throws SQLException {
        ps.setString(1, service.getTypeEn());
        ps.setString(2, service.getTypeUa());
        ps.setString(3, service.getDescriptionEn());
        ps.setString(4, service.getDescriptionUa());
        ps.setBigDecimal(5, service.getPrice());
    }

    private PreparedStatement deleteServicePrepareStatement(int id) throws SQLException {
        String sqlQuery = SqlQuery.SERVICE_DELETE_BY_ID;
        PreparedStatement ps = connection.prepareStatement(sqlQuery);
        ps.setInt(1, id);
        return ps;
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
