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
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static by.ivanchenko.carrental.controller.RequestConstant.*;

public class BookCar implements Command {

    private static final Logger LOGGER = LogManager.getLogger(BookCar.class);

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
                LOGGER.warn("Trying to book the car by no authorized user.");
                return PageResourceManager.getValue(PageParameter.NO_USER);
            }
            
            return PageResourceManager.getValue(PageParameter.CONFIRM_ORDER);
        } catch (ServiceException e) {
            LOGGER.error("Failed to book the car.", e);
            request.setAttribute(MESSAGE, e.getMessage());
            return PageResourceManager.getValue(PageParameter.ERROR_PAGE);
        }
    }
}
