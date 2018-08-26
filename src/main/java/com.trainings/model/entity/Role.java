package com.trainings.model.entity;

import com.trainings.constant.Url;

import java.util.Arrays;

public enum Role {
    GUEST(Url.HOME, new String[]{"/", "asd"}),
    USER(Url.USER_HOME, new String[]{Url.LOGOUT, Url.USER_NEW_ORDER, Url.USER_NEW_ORDER_CONFIRM,"/in/user/menu", ""}),
    MANAGER("home", new String[]{"asd", "asd"}),
    MASTER("home", new String[]{"asd", "asd"}),
    ADMIN("home", new String[]{"asd", "asd"});

    private String homePage;
    private     String[] allowedPages;

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
