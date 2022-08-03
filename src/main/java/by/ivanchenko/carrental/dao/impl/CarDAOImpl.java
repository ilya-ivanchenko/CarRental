package by.ivanchenko.carrental.dao.impl;

import by.ivanchenko.carrental.bean.car.Car;
import by.ivanchenko.carrental.dao.CarDAO;
import by.ivanchenko.carrental.dao.DAOException;
import by.ivanchenko.carrental.dao.impl.connection.ConnectionPool;
import by.ivanchenko.carrental.dao.impl.connection.ConnectionPoolException;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CarDAOImpl implements CarDAO {
    private static final String ID = "id_car";
    private static final String NAME = "name";
    private static final String ENGINE_CAPACITY = "engine_capacity";
    private static final String TRANSMISSION = "transmission";
    private static final String YEAR = "year";
    private static final String DRIVE = "drive";
    private static final String TANK = "tank";
    private static final String CONSUMPTION = "consumption";
    private static final String FUEL = "fuel";
    private static final String BODY_TYPE = "body_type";
    private static final String PRICE = "price";
    private static final String MILEAGE = "mileage";

    private static final String GET_CAR_LIST = "SELECT * FROM cars";
    private static final String GET_CAR_LIST_FILTRED = "SELECT * FROM cars WHERE drive LIKE ? AND transmission LIKE ?  AND " +
            " engine_capacity BETWEEN ? AND ? AND fuel LIKE ? AND consumption BETWEEN ? AND ? AND price BETWEEN ? AND ? " +
            " AND id_car NOT IN (SELECT car_id FROM orders WHERE ? BETWEEN start_date AND end_date" +
            " OR ? BETWEEN start_date AND end_date OR start_date BETWEEN ? AND ? OR end_date BETWEEN ? AND ?)";
    private  static final String GET_CAR = "SELECT * FROM cars WHERE id_car = ?";
    private  static final String ADD_CAR = "INSERT INTO cars (name, engine_capacity, transmission, year, drive, tank," +
            "consumption, fuel, body_type, price) VALUES (?,?,?,?,?,?,?,?,?,?);";
    private  static final String ADD_CAR_ELECTRO = "INSERT INTO cars (name, transmission, year, drive," +
            "fuel, body_type, price, mileage) VALUES (?,?,?,?,?,?,?,?);";
    private  static final String DELETE_CAR = "DELETE FROM cars WHERE id_car = ?";

    @Override
    public List<Car> getCarList() throws DAOException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
           connection = ConnectionPool.getInstance().takeConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(GET_CAR_LIST);

            List<Car> cars =  new ArrayList<>();
            while (resultSet.next()) {
                cars.add(new Car(resultSet.getInt(ID), resultSet.getString(NAME), resultSet.getDouble(ENGINE_CAPACITY),
                        resultSet.getString(TRANSMISSION), resultSet.getInt(YEAR), resultSet.getString(DRIVE),
                        resultSet.getInt(TANK), resultSet.getDouble(CONSUMPTION), resultSet.getString(FUEL),
                        resultSet.getString(BODY_TYPE), resultSet.getInt(PRICE), resultSet.getInt(MILEAGE)));
            }
            return cars;
        } catch (SQLException e) {
            //log.error("some message", e);
            throw new DAOException("Error while getting car list", e);
        } catch (ConnectionPoolException e) {
            throw new DAOException("Error in Connection Pool while getting car list", e);
        }
        finally {
           ConnectionPool.getInstance().closeConnection(connection, statement, resultSet);     // проверить в конце
        }
    }

    @Override
    public List<Car> getCarListFiltred(String transmission, String drive, String fuel, double engine_capacity1, double engine_capacity2,
                                       double consumption1, double consumption2, int price1, int price2,
                                       LocalDate startDate, LocalDate endDate) throws DAOException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionPool.getInstance().takeConnection();
            preparedStatement = connection.prepareStatement(GET_CAR_LIST_FILTRED);
            preparedStatement.setString(1, drive);
            preparedStatement.setString(2, transmission);
            preparedStatement.setDouble(3, engine_capacity1);
            preparedStatement.setDouble(4, engine_capacity2);
            preparedStatement.setString(5, fuel);
            preparedStatement.setDouble(6, consumption1);
            preparedStatement.setDouble(7, consumption2);
            preparedStatement.setInt(8, price1);
            preparedStatement.setInt(9, price2);
            preparedStatement.setDate(10, Date.valueOf(startDate));
            preparedStatement.setDate(11, Date.valueOf(endDate));
            preparedStatement.setDate(12, Date.valueOf(startDate));
            preparedStatement.setDate(13, Date.valueOf(endDate));
            preparedStatement.setDate(14, Date.valueOf(startDate));
            preparedStatement.setDate(15, Date.valueOf(endDate));
            resultSet = preparedStatement.executeQuery();

            List<Car> cars =  new ArrayList<>();
            while (resultSet.next()) {
                cars.add( new Car(resultSet.getInt(ID), resultSet.getString(NAME), resultSet.getDouble(ENGINE_CAPACITY),
                        resultSet.getString(TRANSMISSION), resultSet.getInt(YEAR), resultSet.getString(DRIVE),
                        resultSet.getInt(TANK), resultSet.getDouble(CONSUMPTION), resultSet.getString(FUEL),
                        resultSet.getString(BODY_TYPE), resultSet.getInt(PRICE), resultSet.getInt(MILEAGE)));
            }
            return cars;
        } catch (SQLException e) {
            //log.error("some message", e);
            throw new DAOException("Error while getting car filtred list", e);
        } catch (ConnectionPoolException e) {
            throw new DAOException("Error in Connection Pool while getting car filtred list", e);
        } finally {
            ConnectionPool.getInstance().closeConnection(connection, preparedStatement, resultSet);     // проверить в конце
        }
    }

    @Override
    public Car bookCar(int id) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionPool.getInstance().takeConnection();
            preparedStatement = connection.prepareStatement(GET_CAR);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            Car car = new Car();
            while (resultSet.next()) {
               car = new Car(resultSet.getInt(ID), resultSet.getString(NAME), resultSet.getDouble(ENGINE_CAPACITY),
                        resultSet.getString(TRANSMISSION), resultSet.getInt(YEAR), resultSet.getString(DRIVE),
                        resultSet.getInt(TANK), resultSet.getDouble(CONSUMPTION), resultSet.getString(FUEL),
                        resultSet.getString(BODY_TYPE), resultSet.getInt(PRICE), resultSet.getInt(MILEAGE));
            }
            return car;
        } catch (SQLException e) {
            //log.error("some message", e);
            throw new DAOException("Error while getting booked car list", e);
        } catch (ConnectionPoolException e) {
            throw new DAOException("Error in Connection Pool while getting booked car list", e);
        } finally {
            ConnectionPool.getInstance().closeConnection(connection, preparedStatement, resultSet);     // проверить в конце
        }
    }

    @Override
    public void addCar(Car car) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionPool.getInstance().takeConnection();
            preparedStatement = connection.prepareStatement(ADD_CAR);
            preparedStatement.setString(1, car.getName());
            preparedStatement.setDouble(2, car.getEngineCapacity());
            preparedStatement.setString(3, car.getTransmission());
            preparedStatement.setInt(4, car.getYear());
            preparedStatement.setString(5, car.getDrive());
            preparedStatement.setInt(6, car.getTank());
            preparedStatement.setDouble(7, car.getConsumption());
            preparedStatement.setString(8, car.getFuel());
            preparedStatement.setString(9, car.getBodyType());
            preparedStatement.setInt(10, car.getPrice());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {  // to do      likewise upper 'logIn'
            //log.error("some message", e);
            throw new DAOException("Error while adding new Car", e);
        } catch (ConnectionPoolException e) {
            throw new DAOException("Error in Connection Pool while adding new Car", e);
        } finally {
            ConnectionPool.getInstance().closeConnection(connection, preparedStatement);
        }
    }

    @Override
    public void addCarElectro(Car car) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionPool.getInstance().takeConnection();
            preparedStatement = connection.prepareStatement(ADD_CAR_ELECTRO);
            preparedStatement.setString(1, car.getName());
            preparedStatement.setString(2, car.getTransmission());
            preparedStatement.setInt(3, car.getYear());
            preparedStatement.setString(4, car.getDrive());
            preparedStatement.setString(5, car.getFuel());
            preparedStatement.setString(6, car.getBodyType());
            preparedStatement.setInt(7, car.getPrice());
            preparedStatement.setInt(8, car.getMileage());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {  // to do      likewise upper 'logIn'
            //log.error("some message", e);
            throw new DAOException("Error while adding new Car", e);
        } catch (ConnectionPoolException e) {
            throw new DAOException("Error in Connection Pool while adding new Car", e);
        } finally {
            ConnectionPool.getInstance().closeConnection(connection, preparedStatement);
        }
    }

    @Override
    public void deleteCar(int idCar) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionPool.getInstance().takeConnection();
            preparedStatement = connection.prepareStatement(DELETE_CAR);
            preparedStatement.setInt(1, idCar);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {  // to do      likewise upper 'logIn'
            //log.error("some message", e);
            throw new DAOException("Error while deleting Car", e);
        } catch (ConnectionPoolException e) {
            throw new DAOException("Error in Connection Pool while deleting Car", e);
        } finally {
            ConnectionPool.getInstance().closeConnection(connection, preparedStatement);
        }
    }
}
