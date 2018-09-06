package com.trainings.model.dao.mapper;


import com.trainings.constant.ColumnName;
import com.trainings.model.entity.Serve;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ServiceMapper implements ObjectMapper<Serve> {
    @Override
    public Serve extractOrderFromResultSet(ResultSet rs) throws SQLException {
        return new Serve.ServeBuilder()
                .idServe(rs.getInt(ColumnName.SERVE_ID))
                .typeEn(rs.getString(ColumnName.SERVE_TYPE_EN))
                .typeUa(rs.getString(ColumnName.SERVE_TYPE_UA))
                .descriptionEn(rs.getString(ColumnName.SERVE_DESC_EN))
                .descriptionUa(rs.getString(ColumnName.SERVE_DESC_UA))
                .price(rs.getBigDecimal(ColumnName.SERVE_PRICE))
                .build();
    }
}
