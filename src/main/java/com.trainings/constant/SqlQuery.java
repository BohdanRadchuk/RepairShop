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

    String ORDER_CREATE = "INSERT INTO watch_repair.order (id_user, id_service, status, price, id_manager, " +
            "consideration_date, refuse_reason, id_master, in_work_date, done_date) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    String ORDER_GET_BY_ID = "SELECT * FROM watch_repair.`order` WHERE id_order=?";
    String ORDER_GET_ALL = "SELECT * FROM watch_repair.`order`;";
    String ORDER_GET_ALL_CONFIRM = "SELECT * FROM watch_repair.`order` WHERE `status`='CONFIRM' OR " +
            "`status`='IN_WORK' and id_master=? ORDER BY status DESC, consideration_date;";
    String ORDER_UPDATE = "UPDATE `watch_repair`.`order` SET `id_user`=?, `id_service`=?, `status`=?, `price`=?, " +
            "`id_manager`=?, `consideration_date`=?, `refuse_reason`=?, `id_master`=?, `in_work_date`=?, " +
            "`done_date`=? WHERE `id_order`=?;";
    String ORDER_DELETE = "DELETE from `order` where id_order=?;";
    String GET_ALL_USERS_ORDERS = "SELECT o.id_order, o.id_user, s.id_service, s.type_en, s.type_ua, o.status, " +
            "o.price, o.refuse_reason, c.commentary FROM watch_repair.order o " +
            "LEFT JOIN watch_repair.service s ON o.id_service = s.id_service " +
            "LEFT JOIN`comment` c ON o.id_order = c.id_order WHERE id_user=? ORDER BY o.status DESC, o.id_order;";
    String ORDER_GET_ALL_NEW_MANAGER_ORDERS = "SELECT o.id_order, o.id_user, s.id_service, s.type_en, s.type_ua, " +
            "o.status, o.id_manager, o.price, o.refuse_reason, o.consideration_date FROM watch_repair.order AS o " +
            "LEFT JOIN watch_repair.service AS s ON o.id_service = s.id_service WHERE o.status='NEW' " +
            "ORDER BY o.id_order LIMIT ?, ?;";
    String ORDER_ARCHIVE_ADD = "INSERT INTO `watch_repair`.`order_archive` (`id_archive_order`, `id_user`, " +
            "`id_service`, `status`, `price`, `id_worker`, `done_date`) VALUES (?, ?, ?, ?, ?, ?, ?);";
    String ORDERS_GET_COUNT = "SELECT COUNT(id_order) C FROM `order` WHERE status = 'NEW';";
    String ORDER_GET_OLDER_THAN = "SELECT * FROM `order` WHERE done_date<? OR consideration_date<? and status='REFUSE' " +
            "ORDER BY done_date, consideration_date;";

    String COMMENT_GET_ALL = "SELECT * FROM watch_repair.comment;";
    String COMMENT_GET_BY_ORDER_ID = "SELECT * FROM `watch_repair`.`comment` WHERE id_order=?;";
    String COMMENT_CREATE = "INSERT INTO `watch_repair`.`comment` (`id_order`, `commentary`) VALUES (?, ?);";
    String COMMENT_DELETE = "DELETE from `comment` where id_order=?;";
    String COMMENT_UPDATE = "UPDATE `watch_repair`.`comment` SET `commentary`=? WHERE `id_order`=?";
}
