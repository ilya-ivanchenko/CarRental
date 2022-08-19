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

import java.time.LocalDate;
import java.util.List;

import static by.ivanchenko.carrental.controller.RequestConstant.*;
public class GetCarListCommand implements Command {

    private static final Logger LOGGER = LogManager.getLogger(GetCarListCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            CarService carService = ServiceFactory.getInstance().getCarService();
            List<Car> cars = carService.getCarList();
            HttpSession session = request.getSession(true);
            LocalDate currentDate = LocalDate.now();
            LocalDate maxDate = currentDate.plusDays(180);
            LocalDate currentDatePlus = currentDate.plusDays(1);
            session.setAttribute(CARS, cars);
            session.setAttribute(CURRENT_DATE_PLUS, currentDatePlus);
            session.setAttribute(CURRENT_DATE, currentDate);
            session.setAttribute(MAX_DATE, maxDate);
            session.setAttribute(ENGINE_CAPACITY_TYPE1, ENGINE_CAPACITY_TYPE1_DEFAULT);
            session.setAttribute(ENGINE_CAPACITY_TYPE2, ENGINE_CAPACITY_TYPE2_DEFAULT);
            session.setAttribute(ENGINE_CONSUMPTION_TYPE1, ENGINE_CONSUMPTION_TYPE1_DEFAULT);
            session.setAttribute(ENGINE_CONSUMPTION_TYPE2,ENGINE_CONSUMPTION_TYPE2_DEFAULT);
            session.setAttribute(RENT_PRICE1, RENT_PRICE1_DEFAULT);
            session.setAttribute(RENT_PRICE2, RENT_PRICE2_DEFAULT);
            return PageResourceManager.getValue(PageParameter.MAIN);
        } catch (ServiceException e) {
            LOGGER.error("Failed to show all cars list.", e);
            request.setAttribute(MESSAGE, e.getMessage());
            return PageResourceManager.getValue(PageParameter.ERROR_PAGE);
        }
    }
}
