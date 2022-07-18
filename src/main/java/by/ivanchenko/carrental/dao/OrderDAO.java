package by.ivanchenko.carrental.dao;

import java.util.Date;

public interface OrderDAO {
    void create(int customerId, int carId, Date startDate, Date endDate, int totalPrice) throws DAOException;
}
