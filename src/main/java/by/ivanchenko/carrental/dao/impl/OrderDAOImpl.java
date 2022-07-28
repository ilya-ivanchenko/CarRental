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
    private static final String GIVEN = "given";
    private static final String NEED_REPAIR = "need_repair";
    private static final String APPROVED = "order_approved";
    private static final String REPAIR_PRICE = "repair_price";
    private static final String PASSPORT = "passport";

    private static final String CREATE_ORDER = "INSERT INTO orders (car_id, start_date, end_date, total_price, user_id," +
            " passport, description) VALUES (?,?,?,?,?,?,?)";
    private static final String ORDER_INFO = "SELECT * FROM orders WHERE user_id = ? ORDER BY id_order DESC; ";
    private static final String ORDER_INFO_MANAGER = "SELECT * FROM orders WHERE manager_id = ? ORDER BY id_order DESC;";
    private static final String ORDER_INFO_ALL = "SELECT * FROM orders ORDER BY id_order DESC;";
    private static final String APPROVE_ORDER = "UPDATE orders SET order_approved = 1, manager_id = ? WHERE id_order = ? ";
    private static final String PAY = "UPDATE orders SET payment_rental = 1 WHERE id_order = ?";
    private static final String DELETE_ORDER = "DELETE FROM orders WHERE id_order = ?";
    private static final String GIVE_CAR = "UPDATE orders SET given = 1 WHERE id_order = ?";
    private static final String REGISTER_RETURN = "UPDATE orders SET returned = 1, need_repair = ?, repair_price = ?, description = ? " +
            "WHERE id_order = ?";
    private static final String CANCEL_ORDER_MANAGER = "UPDATE orders SET returned = 1, description = ? WHERE id_order = ?";

    @Override
    public void create(int customerId, int carId, Date startDate, Date endDate, int totalPrice, String passport, String description) throws DAOException {

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
            preparedStatement.setString(6, passport);
            preparedStatement.setString(7, description);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {  // to do      likewise upper 'logIn'
            //log.error("some message", e);
            throw new DAOException("Error while creating new Order", e);
        } catch (ConnectionPoolException e) {
            throw new DAOException("Error in Connection Pool while creating new Order", e);
        } finally {
            ConnectionPool.getInstance().closeConnection(connection, preparedStatement);
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
         while (resultSet.next()) {
             orders.add(new Order(resultSet.getInt(ID_ORDER), resultSet.getInt(ID_CUSTOMER), resultSet.getInt(ID_CAR),
                     resultSet.getInt(ID_MANAGER), resultSet.getDate(START_DATE), resultSet.getDate(END_DATE),
                     resultSet.getInt(TOTAL_PRICE), resultSet.getString(DESCRIPTION), resultSet.getBoolean(PAYMENT),
                     resultSet.getBoolean(RETURNED), resultSet.getBoolean(NEED_REPAIR), resultSet.getBoolean(APPROVED),
                     resultSet.getInt(REPAIR_PRICE), resultSet.getString(PASSPORT), resultSet.getBoolean(GIVEN)));
         }
         return orders;
        } catch (SQLException e) {  // to do      likewise upper 'logIn'
            //log.error("some message", e);
            throw new DAOException("You don't have any orders", e);
        } catch (ConnectionPoolException e) {
            throw new DAOException("Error in Connection Pool while getting info about Orders", e);
        } finally {
            ConnectionPool.getInstance().closeConnection(connection, preparedStatement, resultSet);
        }
    }

    @Override
    public List<Order> getInfoManager(int idManager) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionPool.getInstance().takeConnection();
            preparedStatement = connection.prepareStatement(ORDER_INFO_MANAGER);
            preparedStatement.setInt(1, idManager);
            resultSet = preparedStatement.executeQuery();

            ArrayList<Order> orders = new ArrayList<>();
            while (resultSet.next()) {
                orders.add(new Order(resultSet.getInt(ID_ORDER), resultSet.getInt(ID_CUSTOMER), resultSet.getInt(ID_CAR),
                        resultSet.getInt(ID_MANAGER), resultSet.getDate(START_DATE), resultSet.getDate(END_DATE),
                        resultSet.getInt(TOTAL_PRICE), resultSet.getString(DESCRIPTION), resultSet.getBoolean(PAYMENT),
                        resultSet.getBoolean(RETURNED), resultSet.getBoolean(NEED_REPAIR), resultSet.getBoolean(APPROVED),
                        resultSet.getInt(REPAIR_PRICE), resultSet.getString(PASSPORT), resultSet.getBoolean(GIVEN)));
            }
            return orders;
        } catch (SQLException e) {  // to do      likewise upper 'logIn'
            //log.error("some message", e);
            throw new DAOException("You don't have any orders", e);
        } catch (ConnectionPoolException e) {
            throw new DAOException("Error in Connection Pool while getting info about Orders", e);
        } finally {
            ConnectionPool.getInstance().closeConnection(connection, preparedStatement, resultSet);
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
            while (resultSet.next()) {
                orders.add(new Order(resultSet.getInt(ID_ORDER), resultSet.getInt(ID_CUSTOMER), resultSet.getInt(ID_CAR),
                        resultSet.getInt(ID_MANAGER), resultSet.getDate(START_DATE), resultSet.getDate(END_DATE),
                        resultSet.getInt(TOTAL_PRICE), resultSet.getString(DESCRIPTION), resultSet.getBoolean(PAYMENT),
                        resultSet.getBoolean(RETURNED), resultSet.getBoolean(NEED_REPAIR), resultSet.getBoolean(APPROVED),
                        resultSet.getInt(REPAIR_PRICE), resultSet.getString(PASSPORT), resultSet.getBoolean(GIVEN)));
            }
            return orders;
        } catch (SQLException e) {  // to do      likewise upper 'logIn'
            //log.error("some message", e);
            throw new DAOException("Any orders don't exist", e);
        } catch (ConnectionPoolException e) {
            throw new DAOException("Error in Connection Pool while getting info about Orders", e);
        } finally {
            ConnectionPool.getInstance().closeConnection(connection, statement, resultSet);
        }
    }

    @Override
    public void approve(int idOrder, int idManager) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionPool.getInstance().takeConnection();
            preparedStatement = connection.prepareStatement(APPROVE_ORDER);
            preparedStatement.setInt(1, idManager);
            preparedStatement.setInt(2, idOrder);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {  // to do      likewise upper 'logIn'
            //log.error("some message", e);
            throw new DAOException("Can't to approve the order", e);
        } catch (ConnectionPoolException e) {
            throw new DAOException("Error in Connection Pool while approving the order", e);
        } finally {
            ConnectionPool.getInstance().closeConnection(connection, preparedStatement);
        }
    }

    public void payment(int idOrder) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionPool.getInstance().takeConnection();
            preparedStatement = connection.prepareStatement(PAY);
            preparedStatement.setInt(1, idOrder);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {  // to do      likewise upper 'logIn'
            //log.error("some message", e);
            throw new DAOException("Can't to pay for order", e);
        } catch (ConnectionPoolException e) {
            throw new DAOException("Error in Connection Pool while paying for order", e);
        } finally {
            ConnectionPool.getInstance().closeConnection(connection, preparedStatement);
        }
    }

    @Override
    public void deleteOrder(int idOrder) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionPool.getInstance().takeConnection();

            preparedStatement = connection.prepareStatement(DELETE_ORDER);
            preparedStatement.setInt(1, idOrder);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {  // to do      likewise upper 'logIn'
            //log.error("some message", e);
            throw new DAOException("Error while deleting Order", e);
        } catch (ConnectionPoolException e) {
            throw new DAOException("Error in Connection Pool while deleting Order", e);
        }
        finally {
            ConnectionPool.getInstance().closeConnection(connection, preparedStatement);
        }
    }

    @Override
    public void giveCarCustomer(int idOrder) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionPool.getInstance().takeConnection();
            preparedStatement = connection.prepareStatement(GIVE_CAR);
            preparedStatement.setInt(1, idOrder);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {  // to do      likewise upper 'logIn'
            //log.error("some message", e);
            throw new DAOException("Can't change the  return status", e);
        } catch (ConnectionPoolException e) {
            throw new DAOException("Error in Connection Pool while changing the return status", e);
        } finally {
            ConnectionPool.getInstance().closeConnection(connection, preparedStatement);
        }
    }

    @Override
    public void registerReturn(int needRepair, int repairPrice, String description, int idOrder) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionPool.getInstance().takeConnection();
            preparedStatement = connection.prepareStatement(REGISTER_RETURN);
            preparedStatement.setInt(1, needRepair);
            preparedStatement.setInt(2, repairPrice);
            preparedStatement.setString(3, description);
            preparedStatement.setInt(4, idOrder);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {  // to do      likewise upper 'logIn'
            //log.error("some message", e);
            throw new DAOException("Can't register a return", e);
        } catch (ConnectionPoolException e) {
            throw new DAOException("Error in Connection Pool while registering a return", e);
        } finally {
            ConnectionPool.getInstance().closeConnection(connection, preparedStatement);
        }
    }

    @Override
    public void cancelOrderByManager(String description, int idOrder) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionPool.getInstance().takeConnection();
            preparedStatement = connection.prepareStatement(CANCEL_ORDER_MANAGER);
            preparedStatement.setString(1, description);
            preparedStatement.setInt(2, idOrder);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {  // to do      likewise upper 'logIn'
            //log.error("some message", e);
            throw new DAOException("Can't  cancel the order", e);
        } catch (ConnectionPoolException e) {
            throw new DAOException("Error in Connection Pool while canceling the order", e);
        } finally {
            ConnectionPool.getInstance().closeConnection(connection, preparedStatement);
        }
    }
}

