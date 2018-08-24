package com.trainings.model.dao.impl;

import com.trainings.constant.SqlQuery;
import com.trainings.model.dao.ServiceDao;
import com.trainings.model.dao.mapper.ServiceMapper;
import com.trainings.model.entity.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JDBCServiceDao implements ServiceDao {
    private Connection connection;
    private ServiceMapper serviceMapper = new ServiceMapper();


    public JDBCServiceDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean create(final Service service) {
        try (PreparedStatement ps = newServicePrepareStatement(service)) {
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public Optional<Service> findById(final Integer id) {
        Optional<Service> service = Optional.empty();

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

    private PreparedStatement findByIDPrepareStatement(int id) throws SQLException {
        final String sqlQuery = SqlQuery.SERVICE_GET_BY_ID;
        PreparedStatement ps = connection.prepareStatement(sqlQuery);
        ps.setInt(1, id);
        return ps;
    }

    @Override
    public List<Service> findAll() {
        String sqlQuery = SqlQuery.USER_GET_ALL;
        List<Service> services = new ArrayList<>();
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
    public boolean update(Service service) {
        try (PreparedStatement ps = updateServicePrepareStatement(service)) {
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    private PreparedStatement updateServicePrepareStatement(Service service) throws SQLException {
        String sqlQuery = SqlQuery.SERVICE_UPDATE;
        PreparedStatement ps = connection.prepareStatement(sqlQuery);
        ps.setString(1, service.getNameEn());
        ps.setString(2, service.getNameUa());
        ps.setBigDecimal(3, service.getPrice());
        ps.setInt(4, service.getIdService());
        return ps;
    }

    @Override
    public boolean delete(Integer id) {

        return false;
    }

    private PreparedStatement newServicePrepareStatement(Service service) throws SQLException {
            String sqlQuery = SqlQuery.SERVICE_CREATE;
            PreparedStatement ps = connection.prepareStatement(sqlQuery);
            ps.setString(1, service.getNameEn());
            ps.setString(2, service.getNameUa());
            ps.setBigDecimal(3, service.getPrice());
            return ps;
    }

}
