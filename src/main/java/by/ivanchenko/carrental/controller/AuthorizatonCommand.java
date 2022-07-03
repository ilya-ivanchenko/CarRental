package by.ivanchenko.carrental.controller;

import by.ivanchenko.carrental.bean.user.User;
import by.ivanchenko.carrental.service.ServiceException;
import by.ivanchenko.carrental.service.ServiceFactory;
import by.ivanchenko.carrental.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AuthorizatonCommand implements Command{
    private static final String NAME = "name";
    private static final String SURNAME = "surname";
    private static final String PHONE = "phone";
    private static final String PASSWORD = "password";
    private static final String EMAIL = "email";

    @Override
    public CommandResponse execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            UserService userService = ServiceFactory.getInstance().getUserService();
            User user =  userService.authorize(request.getParameter(EMAIL), request.getParameter(PASSWORD));
         //   request.getSession().setAttribute("name", user.getName());
            request.getSession().setAttribute("user", user);
            // какие еще параметры?2
            if (user.getRole() == 2) {
                return new CommandResponse(PageResourseManager.getInstance().getValue(PageParameter.USER_HOME));
            } else  if (user.getRole() == 3){   // подумать над порядком  if
                //поиск юзера
                //старт сессии
                return new CommandResponse(PageResourseManager.getInstance().getValue(PageParameter.MANAGER_HOME));
            } else {
                return new CommandResponse(PageResourseManager.getInstance().getValue(PageParameter.ADMIN_HOME));
            }
        } catch (ServiceException e) {
            //
            return new CommandResponse(PageResourseManager.getInstance().getValue(PageParameter.ERROR_AUTHORIZATION));
        }
    }
    }