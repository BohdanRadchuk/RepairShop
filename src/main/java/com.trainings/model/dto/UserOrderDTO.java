package com.trainings.model.dto;

import com.trainings.model.entity.Status;

import java.math.BigDecimal;

public class UserOrderDTO {
    private int idOrder;
    private int idUser;
    private int idServe;
    private String typeEn;
    private String typeUa;
    private Status status;
    private BigDecimal price;
    private String commentary;

    public UserOrderDTO(int idOrder, int idUser, int idServe, String typeEn, String typeUa, Status status,
                        BigDecimal price, String commentary) {
        this.idOrder = idOrder;
        this.idUser = idUser;
        this.idServe = idServe;
        this.typeEn = typeEn;
        this.typeUa = typeUa;
        this.status = status;
        this.price = price;
        this.commentary = commentary;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public int getIdUser() {
        return idUser;
    }

    public int getIdServe() {
        return idServe;
    }

    public String getTypeEn() {
        return typeEn;
    }

    public String getTypeUa() {
        return typeUa;
    }

    public Status getStatus() {
        return status;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getCommentary() {
        return commentary;
    }
}
