package by.ivanchenko.carrental.controller.command.impl;

import by.ivanchenko.carrental.bean.user.User;
import by.ivanchenko.carrental.controller.PageParameter;
import by.ivanchenko.carrental.controller.PageResourceManager;
import by.ivanchenko.carrental.controller.command.Command;
import by.ivanchenko.carrental.service.ServiceException;
import by.ivanchenko.carrental.service.ServiceFactory;
import by.ivanchenko.carrental.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import static by.ivanchenko.carrental.controller.command.impl.RequestConstant.*;

public class RegistrationCommand implements Command {

    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        try {
            UserService userService = ServiceFactory.getInstance().getUserService();
                User user  = new User(req.getParameter(NAME), req.getParameter(SURNAME), req.getParameter(PHONE),
                        req.getParameter(PASSWORD),req.getParameter(EMAIL), Integer.parseInt(req.getParameter(ROLE)));
            userService.register(user);
            HttpSession session = req.getSession(true);

            if (session.getAttribute(USER) == null) {
                req.setAttribute(MESSAGE,USER_REG);
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
