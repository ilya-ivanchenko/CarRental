package by.ivanchenko.carrental.controller.command.impl;


import by.ivanchenko.carrental.controller.command.Command;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import static by.ivanchenko.carrental.controller.RequestConstant.*;
public class ChangeLangCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(true);
        session.setAttribute(LOCAL, request.getParameter(LOCAL));
     String commandPage = (session.getAttribute(PAGE)).toString();
        return commandPage;
    }
}
