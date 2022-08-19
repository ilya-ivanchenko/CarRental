package by.ivanchenko.carrental.controller.command.impl;

import by.ivanchenko.carrental.bean.Car;
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

import java.io.IOException;
import java.util.List;

import static by.ivanchenko.carrental.controller.RequestConstant.*;

public class DeleteCar implements Command {

    private static final Logger LOGGER = LogManager.getLogger(DeleteCar.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            CarService carService = ServiceFactory.getInstance().getCarService();
            HttpSession session = request.getSession(true);
            int id = Integer.parseInt(request.getParameter(ID));
            carService.deleteCar(id);
            List<Car> cars = carService.getCarList();
            session.setAttribute(CARS, cars);
            request.setAttribute(MESSAGE, SUCCESSFUL_DELETING_CAR);
            return PageResourceManager.getValue(PageParameter.CAR_INFO);
        } catch (ServiceException e) {
            LOGGER.error("Failed to delete the car from DB.", e);
            request.setAttribute(MESSAGE, e.getMessage());
            return PageResourceManager.getValue(PageParameter.CAR_INFO);
        }
    }
}
