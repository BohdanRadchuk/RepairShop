package com.trainings.model.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OrderArchive {
    private int id_archive_order;
    private int id_user;
    private int id_service;
    private Status status;
    private BigDecimal price;
    private int id_worker;
    private LocalDateTime done_date;

    public OrderArchive(int id_archive_order, int id_user, int id_service, Status status, BigDecimal price, int id_worker, LocalDateTime done_date) {
        this.id_archive_order = id_archive_order;
        this.id_user = id_user;
        this.id_service = id_service;
        this.status = status;
        this.price = price;
        this.id_worker = id_worker;
        this.done_date = done_date;
    }

    public int getId_archive_order() {
        return id_archive_order;
    }

    public int getId_user() {
        return id_user;
    }

    public int getId_service() {
        return id_service;
    }

    public Status getStatus() {
        return status;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getId_worker() {
        return id_worker;
    }

    public LocalDateTime getDone_date() {
        return done_date;
    }
}
