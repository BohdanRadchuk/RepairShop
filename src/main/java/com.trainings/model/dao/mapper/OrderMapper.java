package com.trainings.model.dao.mapper;

import com.trainings.constant.ColumnName;
import com.trainings.model.dto.ManagerOrderDTO;
import com.trainings.model.dto.ManagerOrderDTOBuilder;
import com.trainings.model.dto.UserOrderDTO;
import com.trainings.model.dto.UserOrderDTOBuilder;
import com.trainings.model.entity.Order;
import com.trainings.model.entity.OrderBuilder;
import com.trainings.model.entity.Status;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;

public class OrderMapper implements ObjectMapper<Order> {
    @Override
    public Order extractOrderFromResultSet(ResultSet rs) throws SQLException {
        return new OrderBuilder().setIdOrder(rs.getInt(ColumnName.ORDER_ID))
                .setIdUser(rs.getInt(ColumnName.ORDER_ID_USER))
                .setIdServe(rs.getInt(ColumnName.ORDER_ID_SERVE))
                .setStatus(Status.valueOf(rs.getString(ColumnName.ORDER_STATUS)))
                .setPrice(rs.getBigDecimal(ColumnName.ORDER_PRICE))
                .setIdManager(getIntegerOrNull(rs, ColumnName.ORDER_ID_MANAGER))
                .setConsiderationDate(getDateOrNull(rs, ColumnName.ORDER_CONSIDER_DATE))
                .setRefuseReason(rs.getString(ColumnName.ORDER_REFUSE_REASON))
                .setIdMaster(getIntegerOrNull(rs, ColumnName.ORDER_ID_MASTER))
                .setInWorkDate(getDateOrNull(rs, ColumnName.ORDER_IN_WORK_DATE))
                .setDoneDate(getDateOrNull(rs, ColumnName.ORDER_DONE_DATE))
                .createOrder();
    }


    public UserOrderDTO extractUserOrderDTOFromResultSet(ResultSet rs) throws SQLException {
        return new UserOrderDTOBuilder()
                .setIdOrder(rs.getInt(ColumnName.ORDER_ID))
                .setIdUser(rs.getInt(ColumnName.ORDER_ID_USER))
                .setIdServe(rs.getInt(ColumnName.ORDER_ID_SERVE))
                .setTypeEn(rs.getString(ColumnName.SERVE_TYPE_EN))
                .setTypeUa(rs.getString(ColumnName.SERVE_TYPE_UA))
                .setStatus(Status.valueOf(rs.getString(ColumnName.ORDER_STATUS)))
                .setPrice(rs.getBigDecimal(ColumnName.ORDER_PRICE))
                .setRefuseReason(rs.getString(ColumnName.ORDER_REFUSE_REASON))
                .setCommentary(rs.getString(ColumnName.COMMENT_COMMENTARY))
                .createUserOrderDTO();
    }

    public ManagerOrderDTO extractManagerOrderDTOFromResultSet(ResultSet rs) throws SQLException {
        return new ManagerOrderDTOBuilder()
                .setIdOrder(rs.getInt(ColumnName.ORDER_ID))
                .setIdUser(rs.getInt(ColumnName.ORDER_ID_USER))
                .setIdServe(rs.getInt(ColumnName.ORDER_ID_SERVE))
                .setTypeEn(rs.getString(ColumnName.SERVE_TYPE_EN))
                .setTypeUa(rs.getString(ColumnName.SERVE_TYPE_UA))
                .setStatus(Status.valueOf(rs.getString(ColumnName.ORDER_STATUS)))
                .setId_manager(getIntegerOrNull(rs, ColumnName.ORDER_ID_MANAGER))
                .setConsideration_date(getDateOrNull(rs, ColumnName.ORDER_CONSIDER_DATE))
                .setPrice(rs.getBigDecimal(ColumnName.ORDER_PRICE))
                .setRefuseReason(rs.getString(ColumnName.ORDER_REFUSE_REASON))
                .createManagerOrderDTO();
    }


    private LocalDateTime getDateOrNull(ResultSet rs, String columnName) throws SQLException {
        return Optional.ofNullable(rs.getTimestamp(columnName))
                .map(Timestamp::toLocalDateTime)
                .orElse(null);
    }

    private Integer getIntegerOrNull(ResultSet resultset, String colName) throws SQLException {
        int v = resultset.getInt(colName);
        if (resultset.wasNull()) {
            return null;
        } else {
            return v;
        }
    }

}
