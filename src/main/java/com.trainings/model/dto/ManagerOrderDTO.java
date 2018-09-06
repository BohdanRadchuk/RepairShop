package com.trainings.model.dto;

import com.trainings.model.entity.Status;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ManagerOrderDTO {
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

    ManagerOrderDTO(int idOrder, int idUser, int idServe, String typeEn, String typeUa, Status status,
                    Integer id_manager, LocalDateTime consideration_date, BigDecimal price, String refuseReason) {
        this.idOrder = idOrder;
        this.idUser = idUser;
        this.idServe = idServe;
        this.typeEn = typeEn;
        this.typeUa = typeUa;
        this.status = status;
        this.id_manager = id_manager;
        this.consideration_date = consideration_date;
        this.price = price;
        this.refuseReason = refuseReason;
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

    public Integer getId_manager() {
        return id_manager;
    }

    public LocalDateTime getConsideration_date() {
        return consideration_date;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getRefuseReason() {
        return refuseReason;
    }
}
