package by.ivanchenko.carrental.controller.command.impl;

import by.ivanchenko.carrental.bean.Car;
import by.ivanchenko.carrental.bean.User;
import by.ivanchenko.carrental.controller.PageParameter;
import by.ivanchenko.carrental.controller.PageResourceManager;
import by.ivanchenko.carrental.controller.command.Command;
import by.ivanchenko.carrental.service.CarService;
import by.ivanchenko.carrental.service.ServiceException;
import by.ivanchenko.carrental.service.ServiceFactory;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import static by.ivanchenko.carrental.controller.command.RequestConstant.*;

public class BookCar implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            CarService carService = ServiceFactory.getInstance().getCarService();
            HttpSession session = request.getSession(true);
            int id = Integer.parseInt(request.getParameter(CAR));
            Car car = carService.bookCar(id);
            session.setAttribute(CAR, car);
            User user = (User) session.getAttribute(USER);
            if (user == null) {
                return PageResourceManager.getValue(PageParameter.NO_USER);
            }
            
            return PageResourceManager.getValue(PageParameter.CONFIRM_ORDER);
        } catch (ServiceException e) {
            request.setAttribute(MESSAGE, e.getMessage());
            return PageResourceManager.getValue(PageParameter.ERROR_PAGE);
        }
    }
}
