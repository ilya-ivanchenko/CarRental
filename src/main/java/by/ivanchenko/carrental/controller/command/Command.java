package by.ivanchenko.carrental.controller.command;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public interface Command {
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException;
}
