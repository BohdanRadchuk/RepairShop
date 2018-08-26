package com.trainings.constant;

public interface SqlQuery {
    String USER_GET_ALL = "SELECT * FROM watch_repair.user;";
    String USER_GET_BY_ID = "SELECT * FROM watch_repair.user WHERE id_user=?;";
    String USER_GET_BY_EMAIL = "SELECT * FROM watch_repair.user WHERE email=?;";
    String USER_CREATE = "INSERT INTO watch_repair.user (name, surname, email, password, role) " +
            "VALUES (?, ?, ?, ?, ?);";
    String USER_UPDATE = "UPDATE watch_repair.user SET name=?, surname=?, " +
            "email=?, password=?, role=? WHERE id_user=?;";
    String USER_DELETE_BY_ID = "DELETE FROM watch_repair.user WHERE id_user=?;";

    String SERVICE_GET_ALL = "SELECT * FROM watch_repair.service;";
    String SERVICE_GET_BY_ID = "SELECT * FROM watch_repair.service WHERE id_service=?;";
    String SERVICE_CREATE = "INSERT INTO watch_repair.service(type_en, type_ua, description_en, description_ua, " +
            "price) VALUES (?, ?, ?, ?, ?);";
    String SERVICE_UPDATE = "UPDATE watch_repair.service SET type_en=?, type_ua=?, " +
            "description_en=?, description_ua=?, price=? WHERE id_service=?;";
    String SERVICE_DELETE_BY_ID = "DELETE FROM watch_repair.service WHERE id_service=?;";
}
