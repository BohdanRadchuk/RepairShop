package com.trainings.constant;

public interface Url {
    String HOME = "/home";
    String LOGIN = "/login";
    String LOGIN_CONFIRM = "/login_confirm";
    String LOGOUT = "/logout";
    String REGISTRATION = "/registration";
    String REGISTRATION_CONFIRM = "/registration_confirm";

    String USER_HOME = "/in/user/user_menu";
    String USER_NEW_ORDER = "/in/user/new_order";
    String USER_NEW_ORDER_CONFIRM = "/in/user/new_order_confirm";
    String USERS_ORDERS = "/in/user/users_orders";
    String USER_SEND_COMMENT = "/in/user/send_comment";

    String MANAGER_HOME = "/in/manager/manager_menu";
    String MANAGER_CONFIRM_ORDER = "/in/manager/confirm";
    String MANAGER_REFUSE_ORDER = "/in/manager/refuse";

    String MASTER_HOME = "/in/master/master_menu";
    String MASTER_TO_WORK = "/in/master/to_work";
    String MASTER_DONE = "/in/master/done";

    String WEBINF = "/WEB-INF/page/";
    String JSP = ".jsp";
    String PAGE = "/page";
    String REDIRECT = "redirect:";

    String ADMIN_HOME = "/in/admin/admin_menu";
    String ADMIN_USERS_MENU = "/in/admin/users_menu";
    String ADMIN_EDIT_USER = "/in/admin/user_update";
    String ADMIN_DELETE_USER = "/in/admin/user_delete";

    String ERR_LOGIN = "?err=login";
    String ERR_PASSWORD = "?err=pass";
    String ERR_PRICE = "?err=price";
    String ERR_REGEX = "?err=regex";
    String ERR_EMPTY = "?err=empty";
    String ERR_EMAIL = "?err=email";
    String ERR_PASSWORD_REGEX = "?err=pass_regex";
    String OPERATION_SUCCESS = "?success=true";
}
