package com.trainings.model.entity;

import java.util.Arrays;

public enum Role {
    GUEST("home", new String[]{"asd", "asd"}),
    USER("home", new String[]{"asd", "asd"}),
    MANAGER("home", new String[]{"asd", "asd"}),
    MASTER("home", new String[]{"asd", "asd"}),
    ADMIN("home", new String[]{"asd", "asd"});

    private final String homePage;
    private final String[] allowedPages;

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
