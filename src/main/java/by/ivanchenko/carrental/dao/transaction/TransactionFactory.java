package by.ivanchenko.carrental.dao.transaction;

import by.ivanchenko.carrental.dao.DAOException;
import by.ivanchenko.carrental.dao.impl.connection.ConnectionPool;
import by.ivanchenko.carrental.dao.impl.connection.ConnectionPoolException;

import java.sql.Connection;
import java.sql.SQLException;

public class TransactionFactory {
    private static TransactionFactory instance;

    public TransactionFactory  getInstance() {
        if (instance == null) {
            instance = new TransactionFactory();
        }
        return instance;
    }

    public Transaction getTransaction() throws DAOException {
        try {
           // Connection connection = ConnectionPool.getInstance().   getConnection
            connection.setAutoCommit(false);
            return new TransactionImpl(connection);
        } catch (ConnectionPoolException e) {
            throw new DAOException("Error in Connection Pool while creating transaction", e);
        } catch (SQLException e) {
            throw new DAOException("Error creating transaction", e);
        }
    }
}
