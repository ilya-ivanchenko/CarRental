package by.ivanchenko.carrental.service;

import by.ivanchenko.carrental.bean.order.Order;
import by.ivanchenko.carrental.dao.DAOException;

import java.util.Date;
import java.util.List;

public interface OrderService {
    void create(int customerId, int carId, Date startDate, Date endDate, int totalPrice, String passport, String description) throws ServiceException;
    List<Order> getInfo(int customerId) throws ServiceException;
    List<Order> getInfoManager(int idManager) throws ServiceException;
    List<Order> getInfoAll() throws ServiceException;
    void approve(int idOrder, int idManager) throws ServiceException;
    void payment(int idOrder) throws ServiceException;
    void deleteOrder(int idOrder) throws ServiceException;

    void giveCarCustomer(int idOrder) throws ServiceException;
}
