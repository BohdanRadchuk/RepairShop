package com.trainings.model.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ObjectMapper<T> {

    T extractOrderFromResultSet(ResultSet rs) throws SQLException;

}
