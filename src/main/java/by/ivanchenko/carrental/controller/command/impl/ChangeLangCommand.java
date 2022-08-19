package by.ivanchenko.carrental.controller.command.impl;


import by.ivanchenko.carrental.controller.PageParameter;
import by.ivanchenko.carrental.controller.PageResourceManager;
import by.ivanchenko.carrental.controller.command.Command;
import by.ivanchenko.carrental.service.ServiceException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

import static by.ivanchenko.carrental.controller.RequestConstant.*;
public class ChangeLangCommand implements Command {

    private static final Logger LOGGER = LogManager.getLogger(ChangeLangCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            HttpSession session = request.getSession(true);
            session.setAttribute(LOCAL, request.getParameter(LOCAL));
            return (session.getAttribute(PAGE)).toString();
        } catch (Exception e) {
            LOGGER.error("Failed to change local.", e);
            request.setAttribute(MESSAGE, e.getMessage());
            return PageResourceManager.getValue(PageParameter.ERROR_PAGE);
        }
    }
}
