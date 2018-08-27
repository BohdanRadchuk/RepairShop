package com.trainings.model.entity;

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
}
