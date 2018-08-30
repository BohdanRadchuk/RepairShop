package com.trainings.model.dao.impl;

import com.trainings.model.dao.OrderArchiveDao;
import com.trainings.model.entity.OrderArchive;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class JDBCOrderArchiveDao implements OrderArchiveDao{
    private Connection connection;

    JDBCOrderArchiveDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean create(OrderArchive entity) {
        return false;
    }

    @Override
    public Optional<OrderArchive> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public List<OrderArchive> findAll() {
        return null;
    }

    @Override
    public boolean update(OrderArchive entity) {
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public void close() throws Exception {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
