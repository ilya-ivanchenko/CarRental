package by.ivanchenko.carrental.dao;

import by.ivanchenko.carrental.bean.order.Order;

import java.util.Date;
import java.util.List;

public interface OrderDAO {
    void create(int customerId, int carId, Date startDate, Date endDate, int totalPrice) throws DAOException;
    List<Order> getInfo(int customerId) throws DAOException;

    List<Order> getInfoAll() throws DAOException;
}
