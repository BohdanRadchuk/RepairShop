package com.trainings.model.dao.mapper;

import com.trainings.constant.ColumnName;
import com.trainings.model.dto.UserOrderDTO;
import com.trainings.model.entity.Order;
import com.trainings.model.entity.Serve;
import com.trainings.model.entity.Status;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;

public class OrderMapper implements ObjectMapper<Order>  {
    @Override
    public Order extractFromResultSet(ResultSet rs) throws SQLException {
        int id = rs.getInt(ColumnName.ORDER_ID);
        int idUser = rs.getInt(ColumnName.ORDER_ID_USER);
        int idServe  = rs.getInt(ColumnName.ORDER_ID_SERVE);
        Status status = Status.valueOf(rs.getString(ColumnName.ORDER_STATUS));
        BigDecimal price = rs.getBigDecimal(ColumnName.ORDER_PRICE);
        int idManager = rs.getInt(ColumnName.ORDER_ID_MANAGER);
        LocalDateTime considerDate = Optional.ofNullable(rs.getTimestamp(ColumnName.ORDER_CONSIDER_DATE)).map(Timestamp::toLocalDateTime)
                .orElse(null);
        String refuseReason = rs.getString(ColumnName.ORDER_REFUSE_REASON);
        int idMaster = rs.getInt (ColumnName.ORDER_ID_MASTER);
        LocalDateTime inWorkDate = Optional.ofNullable(rs.getTimestamp(ColumnName.ORDER_IN_WORK_DATE)).map(Timestamp::toLocalDateTime)
                .orElse(null);
        LocalDateTime doneDate = Optional.ofNullable(rs.getTimestamp(ColumnName.ORDER_DONE_DATE))
                .map(Timestamp::toLocalDateTime)
                .orElse(null);

        return new Order(id, idUser, idServe,status, price, idManager, considerDate, refuseReason, idMaster, inWorkDate, doneDate);
    }
    public UserOrderDTO extractUserOrderDTOFromResultSet(ResultSet rs) throws SQLException {
        int id = rs.getInt(ColumnName.ORDER_ID);
        int idUser = rs.getInt(ColumnName.ORDER_ID_USER);
        int idServe = rs.getInt(ColumnName.ORDER_ID_SERVE);
        Status status = Status.valueOf(rs.getString(ColumnName.ORDER_STATUS));
        String typeEn = rs.getString(ColumnName.SERVE_TYPE_EN);
        String typeUA = rs.getString(ColumnName.SERVE_TYPE_UA);
        BigDecimal price = rs.getBigDecimal(ColumnName.ORDER_PRICE);
        String commentary = rs.getString(ColumnName.COMMENT_COMMENTARY);
        return new UserOrderDTO(id, idUser, idServe, typeEn, typeUA, status, price, commentary);
    }

    @Override
    public Order makeUnique(Map<Integer, Order> cache, Order teacher) {
        return null;
    }
}
