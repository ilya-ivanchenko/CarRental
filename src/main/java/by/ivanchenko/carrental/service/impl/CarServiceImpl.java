package by.ivanchenko.carrental.service.impl;

import by.ivanchenko.carrental.bean.car.Car;
import by.ivanchenko.carrental.dao.CarDAO;
import by.ivanchenko.carrental.dao.DAOException;
import by.ivanchenko.carrental.dao.DAOFactory;
import by.ivanchenko.carrental.service.CarService;
import by.ivanchenko.carrental.service.ServiceException;

import java.time.LocalDate;
import java.util.List;

public class CarServiceImpl implements CarService {

    @Override
    public List<Car> getCarList() throws ServiceException {
        try {
            CarDAO carDAO = DAOFactory.getInstance().getCarDAO();
            return carDAO.getCarList();
        } catch (DAOException e) {
            throw new ServiceException("Error displaying car list", e);
        }
    }

    @Override
    public List<Car> getCarListFiltred(String transmission, String drive, String fuel, double engine_capacity1, double engine_capacity2,
                                       double consumption1, double consumption2, int price1, int price2,
                                       LocalDate startDate, LocalDate endDate) throws ServiceException {
        try {
            CarDAO carDAO = DAOFactory.getInstance().getCarDAO();
            return carDAO.getCarListFiltred(transmission, drive, fuel, engine_capacity1,
                    engine_capacity2, consumption1, consumption2, price1, price2, startDate, endDate);    //TO DO  edit    date?
        } catch (DAOException e) {
            throw new ServiceException("Error displaying car filtred list", e);
        }
    }

    @Override
    public Car bookCar(int id) throws ServiceException {
        try {
            CarDAO carDAO = DAOFactory.getInstance().getCarDAO();
            return carDAO.bookCar(id);
        } catch (DAOException e) {
            throw new ServiceException("Error displaying booked car", e);
        }
    }

    @Override
    public void addCar(Car car) throws ServiceException {
        try {
            CarDAO carDAO = DAOFactory.getInstance().getCarDAO();
            carDAO.addCar(car);
        } catch (DAOException e) {
            throw new ServiceException("Error while adding new car");
        }
    }

    @Override
    public void deleteCar(int idCar) throws ServiceException {
        try {
            CarDAO carDAO = DAOFactory.getInstance().getCarDAO();
            carDAO.deleteCar(idCar);
        } catch (DAOException e) {
            throw new ServiceException("Error while deleting car");
        }
    }
}
