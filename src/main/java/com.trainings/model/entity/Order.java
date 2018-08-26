package com.trainings.model.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Order{
    private int idOrder;
    private int idUser;
    private int idServe;
    private Status status;
    private BigDecimal price;
    private int idManager;
    private LocalDateTime considerationDate;
    private String refuseReason;
    private int idMaster;
    private LocalDateTime inWorkDate;
    private LocalDateTime doneDate;

    private Order(int idUser, int idServe, Status status) {
        this.idUser = idUser;
        this.idServe = idServe;
        this.status = status;
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

    public Status getStatus() {
        return status;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getIdManager() {
        return idManager;
    }

    public LocalDateTime getConsiderationDate() {
        return considerationDate;
    }

    public String getRefuseReason() {
        return refuseReason;
    }

    public int getIdMaster() {
        return idMaster;
    }

    public LocalDateTime getInWorkDate() {
        return inWorkDate;
    }

    public LocalDateTime getDoneDate() {
        return doneDate;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public void setIdServe(int idServe) {
        this.idServe = idServe;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setIdManager(int idManager) {
        this.idManager = idManager;
    }

    public void setConsiderationDate(LocalDateTime considerationDate) {
        this.considerationDate = considerationDate;
    }

    public void setRefuseReason(String refuseReason) {
        this.refuseReason = refuseReason;
    }

    public void setIdMaster(int idMaster) {
        this.idMaster = idMaster;
    }

    public void setInWorkDate(LocalDateTime inWorkDate) {
        this.inWorkDate = inWorkDate;
    }

    public void setDoneDate(LocalDateTime doneDate) {
        this.doneDate = doneDate;
    }
}
