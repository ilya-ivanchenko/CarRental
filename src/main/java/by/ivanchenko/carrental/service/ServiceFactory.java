package by.ivanchenko.carrental.service;

import by.ivanchenko.carrental.service.impl.CarServiceImpl;
import by.ivanchenko.carrental.service.impl.OrderServiceImpl;
import by.ivanchenko.carrental.service.impl.UserServiceImpl;

public class ServiceFactory {

    private static ServiceFactory instatnce;
    private final UserService userService;
    private final CarService carService;
    private final OrderService orderService;

    private ServiceFactory() {
        userService = new UserServiceImpl();
        carService = new CarServiceImpl();
        orderService = new OrderServiceImpl();
    }

    public static ServiceFactory getInstance() {
        if (instatnce == null) {
            instatnce = new ServiceFactory();
        }
        return instatnce;
    }

    public UserService getUserService() {
        return userService;
    }

    public CarService getCarService() {
        return carService;
    }

    public OrderService getOrderService() {
        return orderService;
    }
}
