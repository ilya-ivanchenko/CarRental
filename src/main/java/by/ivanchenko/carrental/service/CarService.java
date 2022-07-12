package by.ivanchenko.carrental.service;

import by.ivanchenko.carrental.bean.car.Car;
import by.ivanchenko.carrental.dao.DAOException;

import java.util.List;

public interface CarService {
    List<Car> getCarList() throws ServiceException;
    List<Car> getCarListFiltred(String transmission, String drive) throws ServiceException;  //edit
}
