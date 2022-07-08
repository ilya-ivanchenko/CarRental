package by.ivanchenko.carrental.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface Command {
    public String execute(HttpServletRequest request, HttpServletResponse response);
}
