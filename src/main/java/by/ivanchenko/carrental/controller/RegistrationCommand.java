package by.ivanchenko.carrental.controller;

import by.ivanchenko.carrental.bean.user.User;
import by.ivanchenko.carrental.service.ServiceException;
import by.ivanchenko.carrental.service.ServiceFactory;
import by.ivanchenko.carrental.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


public class RegistrationCommand implements Command {

   // private static final String ID = "id_user";
    private static final String NAME = "name";
    private static final String SURNAME = "surname";
    private static final String PHONE = "phone";
    private static final String PASSWORD = "password";
    private static final String EMAIL = "email";
 //    private static final String ROLE = "id_role";

    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        try {
            UserService userService = ServiceFactory.getInstance().getUserService();
            User user  = new User(req.getParameter(NAME), req.getParameter(SURNAME),
                    req.getParameter(PHONE), req.getParameter(PASSWORD),req.getParameter(EMAIL));
            userService.register(user);
            //*
            HttpSession session = req.getSession(true);
            session.setAttribute("user", user);
            //поиск юзера

        return PageResourseManager.getValue(PageParameter.AFTER_REGISTRATION);
        } catch (ServiceException e) {
            req.setAttribute("message", e.getMessage());
            return PageResourseManager.getValue(PageParameter.ERROR_PAGE);
        }
    }

    //сессия
}
