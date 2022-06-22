package by.ivanchenko.carrental.dao;

import by.ivanchenko.carrental.dao.impl.CarDAOImpl;
import by.ivanchenko.carrental.dao.impl.OrderDAOImpl;
import by.ivanchenko.carrental.dao.impl.UserDAOImpl;

public final  class DAOFactory {    // final or not

    private static DAOFactory instance = new DAOFactory();
    private final UserDAO userDAO = new UserDAOImpl();   // userDAOImpl ?  и т.д.
    private final CarDAO carDAO = new CarDAOImpl();
    private final OrderDAO orderDAO = new OrderDAOImpl();

    private DAOFactory() {
    }

    public static DAOFactory getInstance() {   //synсhronized ?
//        if (instance == null) {
//            instance = new DAOFactory();
//        }
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
