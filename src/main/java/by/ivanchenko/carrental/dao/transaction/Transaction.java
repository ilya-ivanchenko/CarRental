package by.ivanchenko.carrental.dao.transaction;


import by.ivanchenko.carrental.dao.CarDAO;
import by.ivanchenko.carrental.dao.DAOException;
import by.ivanchenko.carrental.dao.OrderDAO;
import by.ivanchenko.carrental.dao.UserDAO;

import java.sql.Connection;

public interface Transaction extends AutoCloseable {
    UserDAO getUserDAO() throws DAOException;;
    CarDAO getCarDAO() throws DAOException;;
    OrderDAO getOrderDAO() throws DAOException;;
     void commit() throws DAOException;

     void rollback() throws DAOException;

     Connection getConnection();
}
