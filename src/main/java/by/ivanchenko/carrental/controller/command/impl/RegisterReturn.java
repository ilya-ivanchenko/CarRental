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
public class RegisterReturn implements Command {

    private static final Logger LOGGER = LogManager.getLogger(RegisterReturn.class);

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
                 LOGGER.info("Repair doesn't need (while registering car return).");
            } else {
                 needRepair = Integer.parseInt(request.getParameter(NEED_REPAIR));
                 repairPrice = Integer.parseInt(request.getParameter(REPAIR_PRICE));
                 LOGGER.info("Repair is need (while registering car return).");
            }

            String description = request.getParameter(DESCRIPTION);
            int idOrder = (Integer) session.getAttribute(ID_ORDER);
            orderService.registerReturn(needRepair, repairPrice, description, idOrder);
            List<Order> orders;
            orders = orderService.getInfoAll();
            session.setAttribute(ORDERS, orders);
            return PageResourceManager.getValue(PageParameter.USER_HOME);
        } catch (ServiceException e) {
            LOGGER.error("Failed to change car status (return).", e);
            request.setAttribute(MESSAGE, e.getMessage());
            return PageResourceManager.getValue(PageParameter.ERROR_PAGE);
        }
    }
}
