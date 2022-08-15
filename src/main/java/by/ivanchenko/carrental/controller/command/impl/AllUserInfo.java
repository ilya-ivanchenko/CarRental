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

import java.io.IOException;
import java.util.List;

import static by.ivanchenko.carrental.controller.command.RequestConstant.*;

public class AllUserInfo implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
        UserService userService = ServiceFactory.getInstance().getUserService();
        List<User> users = userService.allUserInfo();
        HttpSession session = request.getSession(true);
        session.setAttribute(USERS, users);
            return PageResourceManager.getValue(PageParameter.USER_INFO);
        } catch (ServiceException e) {
            request.setAttribute(MESSAGE, e.getMessage());
            return PageResourceManager.getValue(PageParameter.USER_HOME);
        }
    }
}
