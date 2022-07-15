package by.ivanchenko.carrental.service.impl;

import by.ivanchenko.carrental.bean.car.Car;
import by.ivanchenko.carrental.dao.CarDAO;
import by.ivanchenko.carrental.dao.DAOException;
import by.ivanchenko.carrental.dao.DAOFactory;
import by.ivanchenko.carrental.service.CarService;
import by.ivanchenko.carrental.service.ServiceException;

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
                                       double consumption1, double consumption2, int price1, int price2) throws ServiceException {
        try {
            CarDAO carDAO = DAOFactory.getInstance().getCarDAO();
            return carDAO.getCarListFiltred(transmission, drive, fuel, engine_capacity1,
                    engine_capacity2, consumption1, consumption2, price1, price2);//TO DO  edit
        } catch (DAOException e) {
            throw new ServiceException("Error displaying car filtred list", e);
        }
    }
}
