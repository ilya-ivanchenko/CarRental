package by.ivanchenko.carrental.controller.command.impl;

import by.ivanchenko.carrental.bean.car.Car;
import by.ivanchenko.carrental.bean.user.User;
import by.ivanchenko.carrental.controller.PageParameter;
import by.ivanchenko.carrental.controller.PageResourseManager;
import by.ivanchenko.carrental.controller.command.Command;
import by.ivanchenko.carrental.service.CarService;
import by.ivanchenko.carrental.service.ServiceException;
import by.ivanchenko.carrental.service.ServiceFactory;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class BookCar implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            CarService carService = ServiceFactory.getInstance().getCarService();
            HttpSession session = request.getSession(true);
            int id = Integer.parseInt(request.getParameter("car"));
            Car car = carService.bookCar(id);
            session.setAttribute("car", car);
            User user = (User) session.getAttribute("user");
            if (user == null) {
                return PageResourseManager.getValue(PageParameter.NO_USER);
            }
            return PageResourseManager.getValue(PageParameter.CONFIRM_ORDER);
        } catch (ServiceException e) {
            request.setAttribute("message", e.getMessage());
            return PageResourseManager.getValue(PageParameter.ERROR_PAGE);
        }
    }
}
