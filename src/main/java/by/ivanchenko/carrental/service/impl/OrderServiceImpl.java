package by.ivanchenko.carrental.service.impl;

import by.ivanchenko.carrental.dao.DAOException;
import by.ivanchenko.carrental.dao.DAOFactory;
import by.ivanchenko.carrental.dao.OrderDAO;
import by.ivanchenko.carrental.dao.UserDAO;
import by.ivanchenko.carrental.service.OrderService;
import by.ivanchenko.carrental.service.ServiceException;
import by.ivanchenko.carrental.service.ServiceFactory;

import java.util.Date;

public class OrderServiceImpl implements OrderService {
    @Override
    public void create(int customerId, int carId, Date startDate, Date endDate, int totalPrice) throws ServiceException {
        try {
            OrderDAO orderDAO = DAOFactory.getInstance().getOrderDAO();
            orderDAO.create(customerId, carId, startDate, endDate, totalPrice);
        } catch (DAOException e) {
            throw new ServiceException("Error while creating Order", e);
        }
    }
}
