package by.ivanchenko.carrental.service;

import by.ivanchenko.carrental.dao.DAOException;

import java.util.Date;

public interface OrderService {
    void create(int customerId, int carId, Date startDate, Date endDate, int totalPrice) throws ServiceException;
}
