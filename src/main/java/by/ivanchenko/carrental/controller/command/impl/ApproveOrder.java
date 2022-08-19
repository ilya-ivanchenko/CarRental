package by.ivanchenko.carrental.controller.command.impl;

import by.ivanchenko.carrental.bean.Order;
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

public class ApproveOrder implements Command {

    private static final Logger LOGGER = LogManager.getLogger(AllUserInfo.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            OrderService orderService= ServiceFactory.getInstance().getOrderService();
            HttpSession session = request.getSession(true);
            int idOrder = Integer.parseInt(request.getParameter(ID_ORDER));
            int idManager  = Integer.parseInt(request.getParameter(ID_MANAGER));
            orderService.approve(idOrder, idManager);
            List<Order> orders;
            orders = orderService.getInfoAll();
            session.setAttribute(ORDERS, orders);
            return PageResourceManager.getValue(PageParameter.USER_HOME);
        } catch (ServiceException e) {
            LOGGER.error("Failed to approve the order.", e);
            request.setAttribute(MESSAGE, e.getMessage());
            return PageResourceManager.getValue(PageParameter.ERROR_PAGE);
        }
    }
}
