package by.ivanchenko.carrental.controller.command.impl;

import by.ivanchenko.carrental.bean.user.User;
import by.ivanchenko.carrental.controller.PageParameter;
import by.ivanchenko.carrental.controller.PageResourseManager;
import by.ivanchenko.carrental.controller.command.Command;
import by.ivanchenko.carrental.service.ServiceException;
import by.ivanchenko.carrental.service.ServiceFactory;
import by.ivanchenko.carrental.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class AuthorizationCommand implements Command {
    private static final String NAME = "name";
    private static final String SURNAME = "surname";
    private static final String PHONE = "phone";
    private static final String PASSWORD = "password";
    private static final String EMAIL = "email";

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        try {

//            if (request.getSession().getAttribute("user") != null) {
//                return PageResourseManager.getValue(PageParameter.CUSTOMER_HOME);
//            }

            UserService userService = ServiceFactory.getInstance().getUserService();
            User user =  userService.authorize(request.getParameter(EMAIL), request.getParameter(PASSWORD));
            HttpSession session = request.getSession(true);  //если сессии нет, то создать новую
            session.setAttribute("user", user);
            if (user.getRole() == 2) {                          // подумать над порядком  if
                return PageResourseManager.getValue(PageParameter.CUSTOMER_HOME);
            } else  if (user.getRole() == 3){
                return PageResourseManager.getValue(PageParameter.MANAGER_HOME);
            } else {
                return PageResourseManager.getValue(PageParameter.ADMIN_HOME);
            }
        } catch (ServiceException e) {
            request.setAttribute("message", e.getMessage());
            return PageResourseManager.getValue(PageParameter.ERROR_PAGE);
        }
    }

    }