package by.ivanchenko.carrental.dao.impl;

import by.ivanchenko.carrental.bean.order.Order;
import by.ivanchenko.carrental.dao.DAOException;
import by.ivanchenko.carrental.dao.OrderDAO;
import by.ivanchenko.carrental.dao.impl.connection.ConnectionPool;
import by.ivanchenko.carrental.dao.impl.connection.ConnectionPoolException;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderDAOImpl implements OrderDAO {
    private static final String ID_ORDER = "id_order";
    private static final String ID_CAR = "car_id";
    private static final String ID_MANAGER = "manager_id";
    private static final String ID_CUSTOMER = "user_id";
    private static final String START_DATE = "start_date";
    private static final String END_DATE = "end_date";
    private static final String TOTAL_PRICE = "total_price";
    private static final String DESCRIPTION = "description";
    private static final String PAYMENT = "payment_rental";
    private static final String RETURNED = "returned";
    private static final String NEED_REPAIR = "need_repair";
    private static final String APPROVED = "order_approved";
    private static final String REPAIR_PRICE = "repair_price";

    private static final String CREATE_ORDER = "INSERT INTO orders (car_id, start_date, end_date, total_price, user_id) VALUES (?,?,?,?,?)";
    private static final String ORDER_INFO = "SELECT * FROM orders WHERE user_id = ?";
    private static final String ORDER_INFO_ALL = "SELECT * FROM orders";

    @Override
    public void create(int customerId, int carId, Date startDate, Date endDate, int totalPrice) throws DAOException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionPool.getInstance().takeConnection();
            preparedStatement = connection.prepareStatement(CREATE_ORDER);
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

    @Override
    public List<Order> getInfo(int customerId) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionPool.getInstance().takeConnection();
            preparedStatement = connection.prepareStatement(ORDER_INFO);
            preparedStatement.setInt(1, customerId);
            resultSet = preparedStatement.executeQuery();

            ArrayList<Order> orders = new ArrayList<>();
         if (resultSet.next()) {
                orders.add (new Order(resultSet.getInt(ID_ORDER), resultSet.getInt(ID_CUSTOMER), resultSet.getInt(ID_CAR),
                        resultSet.getInt(ID_MANAGER), resultSet.getDate(START_DATE), resultSet.getDate(END_DATE),
                        resultSet.getInt(TOTAL_PRICE), resultSet.getString(DESCRIPTION), resultSet.getBoolean(PAYMENT),
                        resultSet.getBoolean(RETURNED), resultSet.getBoolean(NEED_REPAIR), resultSet.getBoolean(APPROVED),
                        resultSet.getInt(REPAIR_PRICE)));
            } else {
             throw new DAOException("You don't have any orders");
         }
         return orders;
        } catch (SQLException e) {  // to do      likewise upper 'logIn'
            //log.error("some message", e);
            throw new DAOException("You don't have any orders", e);
        } catch (ConnectionPoolException e) {
            throw new DAOException("Error in Connection Pool while getting info about Orders", e);
        } finally {
            ConnectionPool.getInstance().closeConnection(connection, preparedStatement, resultSet);     // проверить в конце
        }
    }


    public List<Order> getInfoAll() throws DAOException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionPool.getInstance().takeConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(ORDER_INFO_ALL);

            ArrayList<Order> orders = new ArrayList<>();
            if (resultSet.next()) {
                orders.add(new Order(resultSet.getInt(ID_ORDER), resultSet.getInt(ID_CUSTOMER), resultSet.getInt(ID_CAR),
                        resultSet.getInt(ID_MANAGER), resultSet.getDate(START_DATE), resultSet.getDate(END_DATE),
                        resultSet.getInt(TOTAL_PRICE), resultSet.getString(DESCRIPTION), resultSet.getBoolean(PAYMENT),
                        resultSet.getBoolean(RETURNED), resultSet.getBoolean(NEED_REPAIR), resultSet.getBoolean(APPROVED),
                        resultSet.getInt(REPAIR_PRICE)));
            } else {
                throw new DAOException("Any orders don't exist");
            }
            return orders;
        } catch (SQLException e) {  // to do      likewise upper 'logIn'
            //log.error("some message", e);
            throw new DAOException("Any orders don't exist", e);
        } catch (ConnectionPoolException e) {
            throw new DAOException("Error in Connection Pool while getting info about Orders", e);
        } finally {
            ConnectionPool.getInstance().closeConnection(connection, statement, resultSet);     // проверить в конце
        }
    }
}

