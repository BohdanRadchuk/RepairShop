package com.trainings.model.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Order {
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


    Order(int idOrder, int idUser, int idServe, Status status, BigDecimal price, Integer idManager, LocalDateTime
            considerationDate, String refuseReason, Integer idMaster, LocalDateTime inWorkDate, LocalDateTime doneDate) {
        this.idOrder = idOrder;
        this.idUser = idUser;
        this.idServe = idServe;
        this.status = status;
        this.price = price;
        this.idManager = idManager;
        this.considerationDate = considerationDate;
        this.refuseReason = refuseReason;
        this.idMaster = idMaster;
        this.inWorkDate = inWorkDate;
        this.doneDate = doneDate;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdServe() {
        return idServe;
    }

    public void setIdServe(int idServe) {
        this.idServe = idServe;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getIdManager() {
        return idManager;
    }

    public void setIdManager(Integer idManager) {
        this.idManager = idManager;
    }

    public LocalDateTime getConsiderationDate() {
        return considerationDate;
    }

    public void setConsiderationDate(LocalDateTime considerationDate) {
        this.considerationDate = considerationDate;
    }

    public String getRefuseReason() {
        return refuseReason;
    }

    public void setRefuseReason(String refuseReason) {
        this.refuseReason = refuseReason;
    }

    public Integer getIdMaster() {
        return idMaster;
    }

    public void setIdMaster(Integer idMaster) {
        this.idMaster = idMaster;
    }

    public LocalDateTime getInWorkDate() {
        return inWorkDate;
    }

    public void setInWorkDate(LocalDateTime inWorkDate) {
        this.inWorkDate = inWorkDate;
    }

    public LocalDateTime getDoneDate() {
        return doneDate;
    }

    public void setDoneDate(LocalDateTime doneDate) {
        this.doneDate = doneDate;
    }

    @Override
    public String toString() {
        return "Order{" +
                "idOrder=" + idOrder +
                ", idUser=" + idUser +
                ", idServe=" + idServe +
                ", status=" + status +
                ", price=" + price +
                ", idManager=" + idManager +
                ", considerationDate=" + considerationDate +
                ", refuseReason='" + refuseReason + '\'' +
                ", idMaster=" + idMaster +
                ", inWorkDate=" + inWorkDate +
                ", doneDate=" + doneDate +
                '}';
    }
}
