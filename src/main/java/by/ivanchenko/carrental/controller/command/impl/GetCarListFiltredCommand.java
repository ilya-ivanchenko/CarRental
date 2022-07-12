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
import jakarta.servlet.http.HttpSession;

import java.util.List;

public class GetCarListFiltredCommand implements Command{
    private static final String TRANSMISSION = "transmission";
    private static final String DRIVE = "drive";

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            CarService carService = ServiceFactory.getInstance().getCarService();
            List<Car> cars = carService.getCarListFiltred(request.getParameter(TRANSMISSION), request.getParameter(DRIVE));
            HttpSession session = request.getSession(true);  //если сессии нет, то создать новую
            session.setAttribute("cars", cars);
            return PageResourseManager.getValue(PageParameter.MAIN);
        } catch (ServiceException e) {
            request.setAttribute("message", e.getMessage());
            return PageResourseManager.getValue(PageParameter.ERROR_PAGE);
        }
    }
}
