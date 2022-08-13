package by.ivanchenko.carrental.controller.command.impl;

import by.ivanchenko.carrental.bean.order.Order;
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

import static by.ivanchenko.carrental.controller.command.impl.RequestConstant.*;
public class RegisterReturn implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            OrderService orderService= ServiceFactory.getInstance().getOrderService();
            HttpSession session = request.getSession(true);
            int needRepair;
            int repairPrice;

            if (request.getParameter(NEED_REPAIR) == null) {
                 needRepair = 0;
                 repairPrice = 0;
            } else {
                 needRepair = Integer.parseInt(request.getParameter(NEED_REPAIR));
                 repairPrice = Integer.parseInt(request.getParameter(REPAIR_PRICE));
            }

            String description = request.getParameter(DESCRIPTION);
            int idOrder = (Integer) session.getAttribute(ID_ORDER);
            orderService.registerReturn(needRepair, repairPrice, description, idOrder);
            List<Order> orders;
            orders = orderService.getInfoAll();
            session.setAttribute(ORDERS, orders);
            return PageResourceManager.getValue(PageParameter.USER_HOME);
        } catch (ServiceException e) {
            request.setAttribute(MESSAGE, e.getMessage());
            return PageResourceManager.getValue(PageParameter.ERROR_PAGE);
        }
    }
}
