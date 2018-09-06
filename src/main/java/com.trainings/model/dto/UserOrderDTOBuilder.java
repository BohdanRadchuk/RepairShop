package com.trainings.model.dto;

import com.trainings.model.entity.Status;

import java.math.BigDecimal;

public class UserOrderDTOBuilder {
    private int idOrder;
    private int idUser;
    private int idServe;
    private String typeEn;
    private String typeUa;
    private Status status;
    private BigDecimal price;
    private String refuseReason;
    private String commentary;

    public UserOrderDTOBuilder setIdOrder(int idOrder) {
        this.idOrder = idOrder;
        return this;
    }

    public UserOrderDTOBuilder setIdUser(int idUser) {
        this.idUser = idUser;
        return this;
    }

    public UserOrderDTOBuilder setIdServe(int idServe) {
        this.idServe = idServe;
        return this;
    }

    public UserOrderDTOBuilder setTypeEn(String typeEn) {
        this.typeEn = typeEn;
        return this;
    }

    public UserOrderDTOBuilder setTypeUa(String typeUa) {
        this.typeUa = typeUa;
        return this;
    }

    public UserOrderDTOBuilder setStatus(Status status) {
        this.status = status;
        return this;
    }

    public UserOrderDTOBuilder setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public UserOrderDTOBuilder setRefuseReason(String refuseReason) {
        this.refuseReason = refuseReason;
        return this;
    }

    public UserOrderDTOBuilder setCommentary(String commentary) {
        this.commentary = commentary;
        return this;
    }

    public UserOrderDTO createUserOrderDTO() {
        return new UserOrderDTO(idOrder, idUser, idServe, typeEn, typeUa, status, price, refuseReason, commentary);
    }
}