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

import java.time.LocalDate;
import java.util.List;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.time.temporal.ChronoUnit.DAYS;
import static by.ivanchenko.carrental.controller.command.impl.RequestConstant.*;

public class GetCarListFiltredCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            CarService carService = ServiceFactory.getInstance().getCarService();
            LocalDate startDate = LocalDate.parse(request.getParameter(DATE_1));
            LocalDate endDate = LocalDate.parse(request.getParameter(DATE_2));
            List<Car> cars = carService.getCarListFiltred(request.getParameter(TRANSMISSION), request.getParameter(DRIVE),
                    request.getParameter(FUEL), parseDouble(request.getParameter(ENGINE_CAPACITY1)),
                    parseDouble(request.getParameter(ENGINE_CAPACITY2)), parseDouble(request.getParameter(CONSUMPTION1)),
                    parseDouble(request.getParameter(CONSUMPTION2)), parseInt(request.getParameter(PRICE1)),
                    parseInt(request.getParameter(PRICE2)), startDate, endDate);
            HttpSession session = request.getSession(true);  //если сессии нет, то создать новую
            session.setAttribute(CARS, cars);
            //SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

            int rentDays = (int) DAYS.between(startDate, endDate);
            session.setAttribute(START_DATE, startDate);
            session.setAttribute(END_DATE, endDate);
            session.setAttribute(RENT_DAYS, rentDays);

            return PageResourseManager.getValue(PageParameter.MAIN);
        } catch (ServiceException e) {
            request.setAttribute(MESSAGE, e.getMessage());
            return PageResourseManager.getValue(PageParameter.ERROR_PAGE);
        }
    }
}
