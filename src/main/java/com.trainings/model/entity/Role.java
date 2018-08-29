package com.trainings.model.entity;

import com.trainings.constant.Url;

import java.util.Arrays;

public enum Role {
    USER(Url.USER_HOME, new String[]{Url.LOGOUT, Url.USER_NEW_ORDER, Url.USER_NEW_ORDER_CONFIRM, Url.USERS_ORDERS,
            Url.USER_SEND_COMMENT}),
    MANAGER(Url.MANAGER_HOME, new String[]{Url.LOGOUT, Url.MANAGER_CONFIRM_ORDER, Url.MANAGER_REFUSE_ORDER}),
    MASTER(Url.MASTER_HOME, new String[]{Url.MASTER_TO_WORK, Url.MASTER_DONE}),
    ADMIN("home", new String[]{"asd", "asd"});

    private String homePage;
    private String[] allowedPages;

    Role(String homePage, String[] allowedPages) {
        this.allowedPages = allowedPages;
        this.homePage = homePage;
    }

    public String homePage() {
        return homePage;
    }

    public String[] allowedPages() {
        return allowedPages;
    }

    @Override
    public String toString() {
        return "Role{" +
                "homePage='" + homePage + '\'' +
                ", allowedPages=" + Arrays.toString(allowedPages) +
                '}';
    }
}
