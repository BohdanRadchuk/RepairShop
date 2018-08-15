package com.trainings.servlet.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

public interface ServletCommand {
    String execute(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException;
}
