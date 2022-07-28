package by.ivanchenko.carrental.controller.command.impl;

import by.ivanchenko.carrental.bean.car.Car;
import by.ivanchenko.carrental.controller.PageParameter;
import by.ivanchenko.carrental.controller.PageResourseManager;
import by.ivanchenko.carrental.controller.command.Command;
import by.ivanchenko.carrental.service.CarService;
import by.ivanchenko.carrental.service.ServiceException;
import by.ivanchenko.carrental.service.ServiceFactory;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import static by.ivanchenko.carrental.controller.command.impl.RequestConstant.*;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class AddCar implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            CarService carService = ServiceFactory.getInstance().getCarService();
            Car car = new Car(request.getParameter(NAME), parseDouble(request.getParameter(ENGINE_CAPACITY)),
                    request.getParameter(TRANSMISSION), parseInt(request.getParameter(YEAR)), request.getParameter(DRIVE),
                    parseInt(request.getParameter(TANK)), parseDouble(request.getParameter(CONSUMPTION)),
                    request.getParameter(FUEL), request.getParameter(BODY_TYPE), parseInt(request.getParameter(PRICE)),
                    parseInt(request.getParameter(MILEAGE)));
            carService.addCar(car);
            request.setAttribute(MESSAGE, SUCCESSFUL_ADDING_CAR);
            return PageResourseManager.getValue(PageParameter.USER_HOME);
        } catch (ServiceException e) {
            request.setAttribute(MESSAGE, e.getMessage());
            return PageResourseManager.getValue(PageParameter.USER_HOME);
        }
    }
}
