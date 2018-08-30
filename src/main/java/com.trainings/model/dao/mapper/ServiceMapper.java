package com.trainings.model.dao.mapper;


import com.trainings.constant.ColumnName;
import com.trainings.model.entity.Serve;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class ServiceMapper implements ObjectMapper<Serve> {
    @Override
    public Serve extractOrderFromResultSet(ResultSet rs) throws SQLException {
        int id = rs.getInt(ColumnName.SERVE_ID);
        String typeEn = rs.getString(ColumnName.SERVE_TYPE_EN);
        String typeUa = rs.getString(ColumnName.SERVE_TYPE_UA);
        String descriptionEn =  rs.getString(ColumnName.SERVE_DESC_EN);
        String descriptionUa = rs.getString(ColumnName.SERVE_DESC_UA);
        BigDecimal price = rs.getBigDecimal(ColumnName.SERVE_PRICE);



        return new Serve.ServeBuilder()
                .idServe(id)
                .typeEn(typeEn)
                .typeUa(typeUa)
                .descriptionEn(descriptionEn)
                .descriptionUa(descriptionUa)
                .price(price)
                .build();
    }


    @Override
    public Serve makeUnique(Map<Integer, Serve> cache, Serve serve) {
        return null;
    }
}
