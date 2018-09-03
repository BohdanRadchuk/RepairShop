package com.trainings.model.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OrderBuilder {
    private int idOrder;
    private int idUser;
    private int idServe;
    private Status status;
    private BigDecimal price;
    private Integer idManager;
    private LocalDateTime considerationDate;
    private String refuseReason;
    private Integer idMaster;
    private LocalDateTime inWorkDate;
    private LocalDateTime doneDate;

    public OrderBuilder setIdOrder(int idOrder) {
        this.idOrder = idOrder;
        return this;
    }

    public OrderBuilder setIdUser(int idUser) {
        this.idUser = idUser;
        return this;
    }

    public OrderBuilder setIdServe(int idServe) {
        this.idServe = idServe;
        return this;
    }

    public OrderBuilder setStatus(Status status) {
        this.status = status;
        return this;
    }

    public OrderBuilder setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public OrderBuilder setIdManager(Integer idManager) {
        this.idManager = idManager;
        return this;
    }

    public OrderBuilder setConsiderationDate(LocalDateTime considerationDate) {
        this.considerationDate = considerationDate;
        return this;
    }

    public OrderBuilder setRefuseReason(String refuseReason) {
        this.refuseReason = refuseReason;
        return this;
    }

    public OrderBuilder setIdMaster(Integer idMaster) {
        this.idMaster = idMaster;
        return this;
    }

    public OrderBuilder setInWorkDate(LocalDateTime inWorkDate) {
        this.inWorkDate = inWorkDate;
        return this;
    }

    public OrderBuilder setDoneDate(LocalDateTime doneDate) {
        this.doneDate = doneDate;
        return this;
    }

    public Order createOrder() {
        return new Order(idOrder, idUser, idServe, status, price, idManager, considerationDate, refuseReason, idMaster, inWorkDate, doneDate);
    }
}