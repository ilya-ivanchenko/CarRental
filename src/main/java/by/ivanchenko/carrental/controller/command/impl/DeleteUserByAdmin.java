package by.ivanchenko.carrental.controller.command.impl;


import by.ivanchenko.carrental.controller.PageParameter;
import by.ivanchenko.carrental.controller.PageResourceManager;
import by.ivanchenko.carrental.controller.command.Command;
import by.ivanchenko.carrental.service.ServiceException;
import by.ivanchenko.carrental.service.ServiceFactory;
import by.ivanchenko.carrental.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.io.IOException;

import static by.ivanchenko.carrental.controller.RequestConstant.*;
import static by.ivanchenko.carrental.controller.RequestConstant.USER_DELETE;

public class DeleteUserByAdmin implements Command {

    private static final Logger LOGGER = LogManager.getLogger(DeleteUserByAdmin.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            UserService userService = ServiceFactory.getInstance().getUserService();
        int id = Integer.parseInt(request.getParameter(ID));
        userService.delete(id);
        request.setAttribute(MESSAGE, USER_DELETE);
        return PageResourceManager.getValue(PageParameter.USER_INFO);
    } catch (ServiceException e) {
        LOGGER.error("Failed to delete the user by admin.", e);
        request.setAttribute(MESSAGE, e.getMessage());
        return PageResourceManager.getValue(PageParameter.USER_HOME);
    }
    }
}
