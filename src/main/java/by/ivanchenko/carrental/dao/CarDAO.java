package by.ivanchenko.carrental.dao;

import by.ivanchenko.carrental.bean.car.Car;

import java.time.LocalDate;
import java.util.List;

public interface CarDAO {
        List<Car> getCarList() throws DAOException;
        List<Car> getCarListFiltred(String transmission, String drive, String fuel, double engine_capacity1, double engine_capacity2,
                                    double consumption1, double consumption2, int price1, int price2,
                                    LocalDate startDate, LocalDate endDate) throws DAOException;  //edit
        Car bookCar(int id) throws DAOException;
}
