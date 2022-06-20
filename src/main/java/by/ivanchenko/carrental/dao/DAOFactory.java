package by.ivanchenko.carrental.dao;

import by.ivanchenko.carrental.dao.impl.CarDAOImpl;
import by.ivanchenko.carrental.dao.impl.OrderDAOImpl;
import by.ivanchenko.carrental.dao.impl.UserDAOImpl;

public  class DAOFactory {

    private static DAOFactory instance;
    private final UserDAO userDAO;
    private final CarDAO carDAO;
    private final OrderDAO orderDAO;

    private DAOFactory() {
       userDAO = new UserDAOImpl();
       carDAO =  new CarDAOImpl();
       orderDAO = new OrderDAOImpl();
    }

    public static DAOFactory getInstance() {
        if (instance == null) {
            instance = new DAOFactory();
        }
        return  instance;
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public CarDAO getCarDAO() {
        return carDAO;
    }

    public OrderDAO getOrderDAO() {
        return orderDAO;
    }
}
