package by.ivanchenko.carrental.service;

import by.ivanchenko.carrental.bean.order.Order;
import by.ivanchenko.carrental.dao.DAOException;

import java.util.Date;
import java.util.List;

public interface OrderService {
    void create(int customerId, int carId, Date startDate, Date endDate, int totalPrice) throws ServiceException;
    List<Order> getInfo(int customerId) throws ServiceException;
    List<Order> getInfoAll() throws ServiceException;
}
