package by.ivanchenko.carrental.controller.command.impl;

import by.ivanchenko.carrental.bean.car.Car;
import by.ivanchenko.carrental.bean.order.Order;
import by.ivanchenko.carrental.bean.user.User;
import by.ivanchenko.carrental.controller.PageParameter;
import by.ivanchenko.carrental.controller.PageResourseManager;
import by.ivanchenko.carrental.controller.command.Command;
import by.ivanchenko.carrental.service.CarService;
import by.ivanchenko.carrental.service.OrderService;
import by.ivanchenko.carrental.service.ServiceException;
import by.ivanchenko.carrental.service.ServiceFactory;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.sql.Date;
import static by.ivanchenko.carrental.controller.command.impl.RequestConstant.*;

public class CreateOrder implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            OrderService orderService= ServiceFactory.getInstance().getOrderService();
            HttpSession session = request.getSession(true);
            User user  = (User) (session.getAttribute(USER));
            Car car = (Car) (session.getAttribute(CAR));
            orderService.create(user.getId(), car.getId(), Date.valueOf((session.getAttribute(START_DATE)).toString()),
                    Date.valueOf((session.getAttribute(END_DATE)).toString()),
                    Integer.parseInt(request.getParameter(TOTAL_PRICE)), request.getParameter(PASSPORT),
                    request.getParameter(COMMENT));
            return PageResourseManager.getValue(PageParameter.AFTER_ORDER);
        } catch (ServiceException e) {
            request.setAttribute(MESSAGE, e.getMessage());
            return PageResourseManager.getValue(PageParameter.ERROR_PAGE);
        }
    }
}
