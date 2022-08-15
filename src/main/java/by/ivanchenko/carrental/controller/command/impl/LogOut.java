package by.ivanchenko.carrental.controller.command.impl;

import by.ivanchenko.carrental.controller.PageParameter;
import by.ivanchenko.carrental.controller.PageResourceManager;
import by.ivanchenko.carrental.controller.command.Command;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import static by.ivanchenko.carrental.controller.command.RequestConstant.*;

public class LogOut implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        
        HttpSession session = request.getSession();
        session.removeAttribute(USER);
        session.removeAttribute(ORDERS);
        return PageResourceManager.getValue(PageParameter.MAIN);
    }
}
