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

import java.util.List;

import static by.ivanchenko.carrental.controller.RequestConstant.*;

public class DeleteOrder implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            OrderService orderService = ServiceFactory.getInstance().getOrderService();
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute(USER);
            int id = Integer.parseInt(request.getParameter(ID));
            orderService.deleteOrder(id);
            List<Order> orders;
            orders = orderService.getInfo(user.getId());
            session.setAttribute(ORDERS, orders);
            return PageResourceManager.getValue(PageParameter.USER_HOME);
        } catch (ServiceException e) {
            request.setAttribute(MESSAGE, e.getMessage());
            return PageResourceManager.getValue(PageParameter.ERROR_PAGE);
        }
    }
}
