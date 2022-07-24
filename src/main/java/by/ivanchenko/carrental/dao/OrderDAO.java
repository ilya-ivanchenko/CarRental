package by.ivanchenko.carrental.dao;

import by.ivanchenko.carrental.bean.order.Order;

import java.util.Date;
import java.util.List;

public interface OrderDAO {
    void create(int customerId, int carId, Date startDate, Date endDate, int totalPrice, String passport, String description) throws DAOException;
    List<Order> getInfo(int customerId) throws DAOException;
    List<Order> getInfoManager(int idManager) throws DAOException;
    List<Order> getInfoAll() throws DAOException;
    void approve(int idOrder, int idManager) throws DAOException;
    void payment(int idOrder) throws DAOException;
    void deleteOrder(int idOrder) throws DAOException;
    void giveCarCustomer(int idOrder) throws DAOException;
}
