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
    public List<Car> getCarListFiltred(String transmission, String drive) throws ServiceException {
        try {
            CarDAO carDAO = DAOFactory.getInstance().getCarDAO();
            return carDAO.getCarListFiltred(transmission, drive);//TO DO  add
        } catch (DAOException e) {
            throw new ServiceException("Error displaying car filtred list", e);
        }
    }
}
