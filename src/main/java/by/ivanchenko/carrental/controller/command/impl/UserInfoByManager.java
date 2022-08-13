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

import java.io.IOException;
import static by.ivanchenko.carrental.controller.command.impl.RequestConstant.*;

public class UserInfoByManager implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            UserService userService = ServiceFactory.getInstance().getUserService();
            HttpSession session = request.getSession(true);
            int idUser = Integer.parseInt(request.getParameter(ID));
            User user = userService.userInfo(idUser);
            session.setAttribute(USER_INFO, user);
            return PageResourceManager.getValue(PageParameter.USER_INFO_BY_MANAGER);
        } catch (ServiceException e) {
            request.setAttribute(MESSAGE, e.getMessage());
            return PageResourceManager.getValue(PageParameter.ERROR_PAGE);
        }
    }
}
