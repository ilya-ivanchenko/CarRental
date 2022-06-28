package by.ivanchenko.carrental.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface Command {
    public CommandResponse execute(HttpServletRequest request, HttpServletResponse response);
}
