package by.ivanchenko.carrental.service;

import by.ivanchenko.carrental.bean.car.Car;
import by.ivanchenko.carrental.dao.DAOException;

import java.util.List;

public interface CarService {
    List<Car> getCarList() throws ServiceException;
    List<Car> getCarListFiltred(String transmission, String drive, String fuel, double engine_capacity1, double engine_capacity2,
                                double consumption1, double consumption2, int price1, int price2) throws ServiceException;  //edit
    Car bookCar(int id) throws ServiceException;
}
