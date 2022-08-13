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
public class EditUser implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            UserService userService = ServiceFactory.getInstance().getUserService();
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute(USER);
            user.setName(request.getParameter(NAME));
            user.setSurname(request.getParameter(SURNAME));
            user.setPhone(request.getParameter(PHONE));
            user.setPassword(request.getParameter(PASSWORD));
            user.setEmail(request.getParameter(EMAIL));
            userService.updateInfo(user);
            session.setAttribute(USER, user);
            request.setAttribute(MESSAGE, EDIT_SAVE);
            return PageResourceManager.getValue(PageParameter.USER_HOME);
        } catch (ServiceException e) {
            request.setAttribute(MESSAGE, e.getMessage());
            return PageResourceManager.getValue(PageParameter.ERROR_PAGE);
        }
    }
}
