package by.ivanchenko.carrental.controller.command.impl;

import by.ivanchenko.carrental.bean.User;
import by.ivanchenko.carrental.controller.PageParameter;
import by.ivanchenko.carrental.controller.PageResourceManager;
import by.ivanchenko.carrental.controller.command.Command;
import by.ivanchenko.carrental.service.ServiceException;
import by.ivanchenko.carrental.service.ServiceFactory;
import by.ivanchenko.carrental.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import static by.ivanchenko.carrental.controller.command.RequestConstant.*;
public class AuthorizationCommand implements Command {


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        try {

            UserService userService = ServiceFactory.getInstance().getUserService();
            User user =  userService.authorize(request.getParameter(EMAIL), request.getParameter(PASSWORD));
            HttpSession session = request.getSession(true);  //если сессии нет, то создать новую
            session.setAttribute(USER, user);
            return PageResourceManager.getValue(PageParameter.USER_HOME);
        } catch (ServiceException e) {
            request.setAttribute(MESSAGE, e.getMessage());
            return PageResourceManager.getValue(PageParameter.AUTHORIZATION);
        }
    }

    }