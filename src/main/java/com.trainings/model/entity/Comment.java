package com.trainings.model.entity;

import java.util.Objects;

public class Comment {
    private int idOrder;
    private String commentary;

    public Comment(int idOrder, String commentary) {
        this.idOrder = idOrder;
        this.commentary = commentary;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public String getCommentary() {
        return commentary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Comment)) return false;
        Comment comment = (Comment) o;
        return getIdOrder() == comment.getIdOrder() &&
                Objects.equals(getCommentary(), comment.getCommentary());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getIdOrder(), getCommentary());
    }
}
