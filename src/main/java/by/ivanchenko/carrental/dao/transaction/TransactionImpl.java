package by.ivanchenko.carrental.dao.transaction;

import by.ivanchenko.carrental.dao.CarDAO;
import by.ivanchenko.carrental.dao.DAOException;
import by.ivanchenko.carrental.dao.OrderDAO;
import by.ivanchenko.carrental.dao.UserDAO;

import java.sql.Connection;
import java.sql.SQLException;

public class TransactionImpl implements Transaction {
    private Connection connection;
    public TransactionImpl(Connection connection) {
        this.connection = connection;
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
        try {
            connection.commit();
        } catch (SQLException e) {
            throw new DAOException("Commit error", e);
        }
    }

    @Override
    public void rollback() throws DAOException {
        try {
            connection.rollback();
        } catch (SQLException e) {
            throw new DAOException("Rollback error", e);
        }
    }

    @Override
    public void close() throws Exception {

    }

    @Override
    public Connection getConnection() {
        return connection;
    }
}
