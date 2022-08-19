package by.ivanchenko.carrental.controller.command.impl;

import by.ivanchenko.carrental.bean.Order;
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

import java.util.List;

import static by.ivanchenko.carrental.controller.RequestConstant.*;
public class GetOrderInfo implements Command {

    private static final Logger LOGGER = LogManager.getLogger(GetOrderInfo.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            OrderService orderService= ServiceFactory.getInstance().getOrderService();
            HttpSession session = request.getSession(true);
            User user = (User) session.getAttribute(USER);
            int role = user.getRole();
            List<Order> orders;
            if ((role == 3) ^ (role == 4)) {
               orders = orderService.getInfoAll();
                LOGGER.info("Admin or manager trying to see all orders info.");
            } else {
                int id = user.getId();
                orders = orderService.getInfo(id);
                LOGGER.info("Customer trying to see all orders info.");
            }
          session.setAttribute(ORDERS, orders);
          return PageResourceManager.getValue(PageParameter.USER_HOME);
        } catch (ServiceException e) {
            LOGGER.error("Failed to show all orders info.", e);
            request.setAttribute(MESSAGE, e.getMessage());
            return PageResourceManager.getValue(PageParameter.USER_HOME);
        }
    }
}
