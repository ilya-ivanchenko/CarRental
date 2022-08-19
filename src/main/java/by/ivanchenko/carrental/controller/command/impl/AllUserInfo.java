package by.ivanchenko.carrental.controller.command.impl;

import by.ivanchenko.carrental.bean.User;
import by.ivanchenko.carrental.controller.Controller;
import by.ivanchenko.carrental.controller.PageParameter;
import by.ivanchenko.carrental.controller.PageResourceManager;
import by.ivanchenko.carrental.controller.command.Command;
import by.ivanchenko.carrental.service.ServiceException;
import by.ivanchenko.carrental.service.ServiceFactory;
import by.ivanchenko.carrental.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.List;

import static by.ivanchenko.carrental.controller.RequestConstant.*;

public class AllUserInfo implements Command {

    private static final Logger LOGGER = LogManager.getLogger(AllUserInfo.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
        UserService userService = ServiceFactory.getInstance().getUserService();
        List<User> users = userService.allUserInfo();
        HttpSession session = request.getSession(true);
        session.setAttribute(USERS, users);
            return PageResourceManager.getValue(PageParameter.USER_INFO);
        } catch (ServiceException e) {
            LOGGER.error("Failed to see all users info.", e);
            request.setAttribute(MESSAGE, e.getMessage());
            return PageResourceManager.getValue(PageParameter.USER_HOME);
        }
    }
}
