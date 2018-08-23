package com.trainings.model.entity;

import java.math.BigDecimal;

public class Service {
    private int idService;
    private String nameEn;
    private String nameUa;
    private BigDecimal price;

    public int getIdService() {
        return idService;
    }

    public String getNameEn() {
        return nameEn;
    }

    public String getNameUa() {
        return nameUa;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
