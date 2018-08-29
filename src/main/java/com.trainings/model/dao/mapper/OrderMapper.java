package com.trainings.model.dao.mapper;

import com.trainings.constant.ColumnName;
import com.trainings.model.dto.ManagerOrderDTO;
import com.trainings.model.dto.UserOrderDTO;
import com.trainings.model.entity.Order;
import com.trainings.model.entity.Status;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;

public class OrderMapper implements ObjectMapper<Order> {
    @Override
    public Order extractFromResultSet(ResultSet rs) throws SQLException {
        int id = rs.getInt(ColumnName.ORDER_ID);
        int idUser = rs.getInt(ColumnName.ORDER_ID_USER);
        int idServe = rs.getInt(ColumnName.ORDER_ID_SERVE);
        Status status = Status.valueOf(rs.getString(ColumnName.ORDER_STATUS));
        BigDecimal price = rs.getBigDecimal(ColumnName.ORDER_PRICE);
        Integer idManager =getIntegerOrNull(rs, ColumnName.ORDER_ID_MANAGER);
        LocalDateTime considerDate = getDateOrNull(rs, ColumnName.ORDER_CONSIDER_DATE);
        String refuseReason = rs.getString(ColumnName.ORDER_REFUSE_REASON);
        Integer idMaster = getIntegerOrNull(rs, ColumnName.ORDER_ID_MASTER);
        LocalDateTime inWorkDate = getDateOrNull(rs, ColumnName.ORDER_IN_WORK_DATE);
        LocalDateTime doneDate = getDateOrNull(rs, ColumnName.ORDER_DONE_DATE);
        return new Order(id, idUser, idServe, status, price, idManager, considerDate, refuseReason, idMaster, inWorkDate, doneDate);
    }


    public UserOrderDTO extractUserOrderDTOFromResultSet(ResultSet rs) throws SQLException {
        int id = rs.getInt(ColumnName.ORDER_ID);
        int idUser = rs.getInt(ColumnName.ORDER_ID_USER);
        int idServe = rs.getInt(ColumnName.ORDER_ID_SERVE);
        Status status = Status.valueOf(rs.getString(ColumnName.ORDER_STATUS));
        String typeEn = rs.getString(ColumnName.SERVE_TYPE_EN);
        String typeUa = rs.getString(ColumnName.SERVE_TYPE_UA);
        BigDecimal price = rs.getBigDecimal(ColumnName.ORDER_PRICE);
        String refuseReason = rs.getString(ColumnName.ORDER_REFUSE_REASON);
        String commentary = rs.getString(ColumnName.COMMENT_COMMENTARY);
        return new UserOrderDTO(id, idUser, idServe, typeEn, typeUa, status, price, refuseReason, commentary);
    }

    public ManagerOrderDTO extractManagerOrderDTOFromResultSet(ResultSet rs) throws SQLException {
        int id = rs.getInt(ColumnName.ORDER_ID);
        int idUser = rs.getInt(ColumnName.ORDER_ID_USER);
        int idServe = rs.getInt(ColumnName.ORDER_ID_SERVE);
        Status status = Status.valueOf(rs.getString(ColumnName.ORDER_STATUS));
        String typeEn = rs.getString(ColumnName.SERVE_TYPE_EN);
        String typeUa = rs.getString(ColumnName.SERVE_TYPE_UA);
        BigDecimal price = rs.getBigDecimal(ColumnName.ORDER_PRICE);
        Integer idManager = rs.getInt(ColumnName.ORDER_ID_MANAGER);
        LocalDateTime considerDate = getDateOrNull(rs, ColumnName.ORDER_CONSIDER_DATE);
        String refuseReason = rs.getString(ColumnName.ORDER_REFUSE_REASON);
        return new ManagerOrderDTO(id, idUser, idServe, typeEn, typeUa, status, idManager, considerDate, price, refuseReason);
    }


    @Override
    public Order makeUnique(Map<Integer, Order> cache, Order teacher) {
        return null;
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
