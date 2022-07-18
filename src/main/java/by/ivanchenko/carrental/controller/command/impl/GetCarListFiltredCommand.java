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

public class GetCarListFiltredCommand implements Command{
    private static final String ID = "id_car";
    private static final String NAME = "name";
    private static final String ENGINE_CAPACITY1 = "engine_capacity1";
    private static final String ENGINE_CAPACITY2 = "engine_capacity2";
    private static final String TRANSMISSION = "transmission";
    private static final String YEAR = "year";
    private static final String DRIVE = "drive";

    private static final String TANK = "tank";
    private static final String CONSUMPTION1 = "consumption1";
    private static final String CONSUMPTION2 = "consumption2";
    private static final String FUEL = "fuel";
    private static final String BODY_TYPE = "body_type";
    private static final String PRICE1 = "price1";
    private static final String PRICE2 = "price2";
    private static final String MILEAGE = "mileage";

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            CarService carService = ServiceFactory.getInstance().getCarService();
            List<Car> cars = carService.getCarListFiltred(request.getParameter(TRANSMISSION), request.getParameter(DRIVE),
                    request.getParameter(FUEL), parseDouble(request.getParameter(ENGINE_CAPACITY1)),
                    parseDouble(request.getParameter(ENGINE_CAPACITY2)), parseDouble(request.getParameter(CONSUMPTION1)),
                    parseDouble(request.getParameter(CONSUMPTION2)), parseInt(request.getParameter(PRICE1)), parseInt(request.getParameter(PRICE2)));
            HttpSession session = request.getSession(true);  //если сессии нет, то создать новую
            session.setAttribute("cars", cars);
            LocalDate  startDate =  LocalDate.parse(request.getParameter("date1"));
            LocalDate  endDate =  LocalDate.parse(request.getParameter("date2"));
            int rentDays = (int) DAYS.between(startDate, endDate);
//            int totalPrice =

//            session.setAttribute("filter", request.getParameter("filter"));   закинуть фильтр в сессию?
            session.setAttribute("start_date", startDate);
            session.setAttribute("end_date", endDate);
            session.setAttribute("rent_days", rentDays);


// TO DO: add dates


            System.out.println("start: " + startDate);
            System.out.println("end: " + endDate);
            System.out.println("days:" + rentDays);


            return PageResourseManager.getValue(PageParameter.MAIN);
        } catch (ServiceException e) {
            request.setAttribute("message", e.getMessage());
            return PageResourseManager.getValue(PageParameter.ERROR_PAGE);
        }
    }
}
