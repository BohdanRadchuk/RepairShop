package com.trainings.constant;

public interface LoggerMessage {
    String ERR_ORDERS_ARCHIVING = "Cant complete orders archiving";
    String SCHEDULE_TASK_TRIGGER = "Schedule task triggered";
    String SCHEDULE_TASK_COMPLETE = "Schedule task successfully complete";
    String ERR_USER_SERVICE_DELETE_USER = "error delete user";
    String ERR_USER_SERVICE_UPDATE_USER = "error update user";
    String ERR_USER_SERVICE_USER_FIND_EMAIL = "error find user by email";
    String ERR_USER_SERVICE_USER_EMAIL_EXIST = "error find by email user exists";
    String ERR_USER_SERVICE_FIND_ALL = "error find all users";
    String ERR_USER_SERVICE_CREATE_USER = "error create user";
    String ERR_SERVE_SERVICE_GET_ALL = "error find all serves";
    String ERR_SERVE_SERVICE_FIND_BY_ID = "error find serve by id";
    String ERR_COMMENT_SERVICE_CREATE_COMMENT = "error create comment";
    String ERR_SERVE_COMMAND_FIND_BY_ID = "error cant get serve by Id";
    String ERR_SESSION_INVALIDATION = "error cant invalidate session";
}
