package by.ivanchenko.carrental.dao.transaction;

import by.ivanchenko.carrental.dao.CarDAO;
import by.ivanchenko.carrental.dao.DAOException;
import by.ivanchenko.carrental.dao.OrderDAO;
import by.ivanchenko.carrental.dao.UserDAO;

import java.sql.Connection;

public class TransactionImpl implements Transaction {
    private Connection connection;
    public TransactionImpl(Connection connection) {
        this.connection = connection;
    }

//

    @Override
    public void close() throws Exception {

    }

    @Override
    public UserDAO getUserDAO() throws DAOException {
        return null;
    }

    @Override
    public CarDAO getCarDAO() throws DAOException {
        return null;
    }

    @Override
    public OrderDAO getOrderDAO() throws DAOException {
        return null;
    }

    @Override
    public void commit() throws DAOException {

    }

    @Override
    public void rollback() throws DAOException {

    }

    @Override
    public Connection getConnection() {
        return null;
    }
}
