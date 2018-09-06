package com.trainings.model.dto;

import com.trainings.model.entity.Status;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ManagerOrderDTOBuilder {
    private int idOrder;
    private int idUser;
    private int idServe;
    private String typeEn;
    private String typeUa;
    private Status status;
    private Integer id_manager;
    private LocalDateTime consideration_date;
    private BigDecimal price;
    private String refuseReason;

    public ManagerOrderDTOBuilder setIdOrder(int idOrder) {
        this.idOrder = idOrder;
        return this;
    }

    public ManagerOrderDTOBuilder setIdUser(int idUser) {
        this.idUser = idUser;
        return this;
    }

    public ManagerOrderDTOBuilder setIdServe(int idServe) {
        this.idServe = idServe;
        return this;
    }

    public ManagerOrderDTOBuilder setTypeEn(String typeEn) {
        this.typeEn = typeEn;
        return this;
    }

    public ManagerOrderDTOBuilder setTypeUa(String typeUa) {
        this.typeUa = typeUa;
        return this;
    }

    public ManagerOrderDTOBuilder setStatus(Status status) {
        this.status = status;
        return this;
    }

    public ManagerOrderDTOBuilder setId_manager(Integer id_manager) {
        this.id_manager = id_manager;
        return this;
    }

    public ManagerOrderDTOBuilder setConsideration_date(LocalDateTime consideration_date) {
        this.consideration_date = consideration_date;
        return this;
    }

    public ManagerOrderDTOBuilder setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public ManagerOrderDTOBuilder setRefuseReason(String refuseReason) {
        this.refuseReason = refuseReason;
        return this;
    }

    public ManagerOrderDTO createManagerOrderDTO() {
        return new ManagerOrderDTO(idOrder, idUser, idServe, typeEn, typeUa, status, id_manager, consideration_date, price, refuseReason);
    }
}