package by.ivanchenko.carrental.dao.impl;

import by.ivanchenko.carrental.dao.DAOException;
import by.ivanchenko.carrental.dao.OrderDAO;
import by.ivanchenko.carrental.dao.impl.connection.ConnectionPool;
import by.ivanchenko.carrental.dao.impl.connection.ConnectionPoolException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class OrderDAOImpl implements OrderDAO {
    private static final String CREATE_ORDER = "INSERT INTO orders (car_id, start_date, end_date, total_price, user_id) VALUES (?,?,?,?,?)";

    @Override
    public void create(int customerId, int carId, Date startDate, Date endDate, int totalPrice) throws DAOException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionPool.getInstance().takeConnection();
//            ConnectionPool connectionPool = new ConnectionPool();
//            connection = connectionPool.takeConnection();
            connection.prepareStatement(CREATE_ORDER);
            preparedStatement.setInt(1, carId);
            preparedStatement.setDate(2, (java.sql.Date) startDate);
            preparedStatement.setDate(3, (java.sql.Date) endDate);
            preparedStatement.setInt(4, totalPrice);
            preparedStatement.setInt(5, customerId);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {  // to do      likewise upper 'logIn'
            //log.error("some message", e);
            throw new DAOException("Error while creating new Order", e);
        } catch (ConnectionPoolException e) {
            throw new DAOException("Error in Connection Pool while creating new Order", e);
        } finally {
            ConnectionPool.getInstance().closeConnection(connection, preparedStatement);     // проверить в конце
        }
    }
}
