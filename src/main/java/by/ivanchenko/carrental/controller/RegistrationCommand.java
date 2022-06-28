package by.ivanchenko.carrental.controller;

import by.ivanchenko.carrental.bean.user.User;
import by.ivanchenko.carrental.service.ServiceException;
import by.ivanchenko.carrental.service.ServiceFactory;
import by.ivanchenko.carrental.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class RegistrationCommand implements Command {

   // private static final String ID = "id_user";
    private static final String NAME = "name";
    private static final String SURNAME = "surname";
    private static final String PHONE = "phone";
    private static final String PASSWORD = "password";
    private static final String EMAIL = "email";
  //  private static final String ROLE = "id_role";

    public CommandResponse execute(HttpServletRequest req, HttpServletResponse resp) {
        try {
            UserService userService = ServiceFactory.getInstance().getUserService();
            userService.register(new User(req.getParameter(NAME), req.getParameter(SURNAME),
                    req.getParameter(PHONE), req.getParameter(PASSWORD),req.getParameter(EMAIL), 2));  //2 на текст заменить

            //поиск юзера
            //старт сессии

        return new CommandResponse(PageResourseManager.getInstance().getValue(PageParameter.USER_HOME));
        } catch (ServiceException e) {
            return new CommandResponse(PageResourseManager.getInstance().getValue(PageParameter.ERROR_REGISTRATION));
        }
    }

    //сессия
}
