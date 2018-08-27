package com.trainings.model.dao.mapper;

import com.trainings.constant.ColumnName;
import com.trainings.model.entity.Comment;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class CommentMapper implements ObjectMapper<Comment>{
    @Override
    public Comment extractFromResultSet(ResultSet rs) throws SQLException {
        int id = rs.getInt(ColumnName.ORDER_ID);
        String commentary = rs.getString(ColumnName.COMMENT_COMMENTARY);

        return new Comment(id, commentary);
    }

    @Override
    public Comment makeUnique(Map<Integer, Comment> cache, Comment teacher) {
        return null;
    }
}
