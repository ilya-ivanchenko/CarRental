package by.ivanchenko.carrental.controller.command.impl;

import by.ivanchenko.carrental.bean.Car;
import by.ivanchenko.carrental.bean.User;
import by.ivanchenko.carrental.controller.PageParameter;
import by.ivanchenko.carrental.controller.PageResourceManager;
import by.ivanchenko.carrental.controller.command.Command;
import by.ivanchenko.carrental.service.OrderService;
import by.ivanchenko.carrental.service.ServiceException;
import by.ivanchenko.carrental.service.ServiceFactory;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Date;
import static by.ivanchenko.carrental.controller.RequestConstant.*;

public class CreateOrder implements Command {

    private static final Logger LOGGER = LogManager.getLogger(CreateOrder.class);

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
            return PageResourceManager.getValue(PageParameter.AFTER_ORDER);
        } catch (ServiceException e) {
            LOGGER.error("Failed creating new order.", e);
            request.setAttribute(MESSAGE, e.getMessage());
            return PageResourceManager.getValue(PageParameter.CONFIRM_ORDER);
        }
    }
}
