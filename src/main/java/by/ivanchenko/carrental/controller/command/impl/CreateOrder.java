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


public class CreateOrder implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            OrderService orderService= ServiceFactory.getInstance().getOrderService();
            HttpSession session = request.getSession(true);
            User user  = (User) (session.getAttribute("user"));
            Car car = (Car) (session.getAttribute("car"));

 //
            System.out.println("start date" + Date.valueOf(request.getParameter("start_date")));
            System.out.println("end_date" + Date.valueOf(request.getParameter("end_date")));
            System.out.println("totalPrice " + Integer.parseInt(request.getParameter("total_price")));
//

            orderService.create(user.getId(), car.getId(), Date.valueOf(request.getParameter("start_date")),
                    Date.valueOf(request.getParameter("end_date")), Integer.parseInt(request.getParameter("total_price"))  ); //

            return PageResourseManager.getValue(PageParameter.AFTER_ORDER);
        } catch (ServiceException e) {
            request.setAttribute("message", e.getMessage());
            return PageResourseManager.getValue(PageParameter.ERROR_PAGE);
        }
    }
}
