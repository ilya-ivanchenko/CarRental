package by.ivanchenko.carrental.controller.command.impl;

import by.ivanchenko.carrental.controller.PageParameter;
import by.ivanchenko.carrental.controller.PageResourceManager;
import by.ivanchenko.carrental.controller.command.Command;
import by.ivanchenko.carrental.service.OrderService;
import by.ivanchenko.carrental.service.ServiceException;
import by.ivanchenko.carrental.service.ServiceFactory;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import static by.ivanchenko.carrental.controller.command.impl.RequestConstant.*;
public class PayForOrder implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            OrderService orderService= ServiceFactory.getInstance().getOrderService();
            HttpSession session = request.getSession(true);

            int idOrder = (Integer) session.getAttribute(ID_ORDER);
            orderService.payment(idOrder);
            request.setAttribute(MESSAGE, PAY_OK);
            return PageResourceManager.getValue(PageParameter.PAY);
        } catch (ServiceException e) {
            request.setAttribute(MESSAGE, e.getMessage());
            return PageResourceManager.getValue(PageParameter.PAY);
        }
    }
}
