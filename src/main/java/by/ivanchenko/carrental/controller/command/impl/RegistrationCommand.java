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

import static by.ivanchenko.carrental.controller.RequestConstant.*;

public class RegistrationCommand implements Command {

    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        try {
            UserService userService = ServiceFactory.getInstance().getUserService();
                User user  = new User(req.getParameter(NAME), req.getParameter(SURNAME), req.getParameter(PHONE),
                        req.getParameter(PASSWORD).toCharArray(),req.getParameter(EMAIL), Integer.parseInt(req.getParameter(ROLE)));
            boolean registration = userService.register(user);
            HttpSession session = req.getSession(true);
            req.setAttribute(REGISTRATION_STATUS, registration);

            if (session.getAttribute(USER) == null) {
                return PageResourceManager.getValue(PageParameter.REGISTRATION);
            } else {
                req.setAttribute(MESSAGE,MANAGER_REG);
                return PageResourceManager.getValue(PageParameter.USER_HOME);
            }
        } catch (ServiceException e) {
            req.setAttribute(MESSAGE, e.getMessage());
            return PageResourceManager.getValue(PageParameter.REGISTRATION);
        }
    }
}
