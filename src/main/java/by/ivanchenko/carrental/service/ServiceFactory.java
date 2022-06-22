package by.ivanchenko.carrental.service;

import by.ivanchenko.carrental.service.impl.CarServiceImpl;
import by.ivanchenko.carrental.service.impl.OrderServiceImpl;
import by.ivanchenko.carrental.service.impl.UserServiceImpl;

public class ServiceFactory {

    private static ServiceFactory instatnce = new ServiceFactory();
    private final UserService userService = new UserServiceImpl();
    private final CarService carService = new CarServiceImpl();
    private final OrderService orderService = new OrderServiceImpl();

    private ServiceFactory() {
    }

    public static ServiceFactory getInstance() {    //synсhronized ?
//        if (instatnce == null) {
//            instatnce = new ServiceFactory();
//        }
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
