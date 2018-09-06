package com.trainings.constant;

public interface Regex {
    String REG_NAME = "(?:[A-Z]\\w+|[А-ЩЬЮЯҐІЇЄ][а-щьюяґіїє]+)";
    String REG_PASS = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{6,}$";
    String REG_DIGITS = "\\d";
}
