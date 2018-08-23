package com.trainings.model.dao.mapper;

import com.trainings.model.entity.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class ServiceMapper implements ObjectMapper<Service> {
    @Override
    public Service extractFromResultSet(ResultSet rs) throws SQLException {
        return null;
    }

    @Override
    public Service makeUnique(Map<Integer, Service> cache, Service teacher) {
        return null;
    }
}
