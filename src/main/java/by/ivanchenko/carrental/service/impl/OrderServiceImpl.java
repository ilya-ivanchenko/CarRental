package by.ivanchenko.carrental.service.impl;

import by.ivanchenko.carrental.bean.order.Order;
import by.ivanchenko.carrental.dao.DAOException;
import by.ivanchenko.carrental.dao.DAOFactory;
import by.ivanchenko.carrental.dao.OrderDAO;
import by.ivanchenko.carrental.dao.UserDAO;
import by.ivanchenko.carrental.service.OrderService;
import by.ivanchenko.carrental.service.ServiceException;
import by.ivanchenko.carrental.service.ServiceFactory;
import by.ivanchenko.carrental.service.Validator;

import java.util.Date;
import java.util.List;

public class OrderServiceImpl implements OrderService {
    private static final Validator validator = new Validator();
    @Override
    public void create(int customerId, int carId, Date startDate, Date endDate, int totalPrice, String passport, String description) throws ServiceException {

        if (!validator.passportValidation(passport)){
            throw new ServiceException("Incorrect passport ID format");
        }
        try {
            OrderDAO orderDAO = DAOFactory.getInstance().getOrderDAO();
            orderDAO.create(customerId, carId, startDate, endDate, totalPrice, passport, description);
        } catch (DAOException e) {
            throw new ServiceException("Error while creating Order", e);
        }
    }

    @Override
    public List<Order> getInfo(int customerId) throws ServiceException {
        try {
            OrderDAO orderDAO = DAOFactory.getInstance().getOrderDAO();
            return orderDAO.getInfo(customerId);
        } catch (DAOException e) {
            throw new ServiceException("You don't have any orders", e);
        }
    }

    @Override
    public List<Order> getInfoManager(int idManager) throws ServiceException {
        try {
            OrderDAO orderDAO = DAOFactory.getInstance().getOrderDAO();
            return orderDAO.getInfoManager(idManager);
        } catch (DAOException e) {
            throw new ServiceException("You don't have any orders", e);
        }
    }

    @Override
    public List<Order> getInfoAll() throws ServiceException {
        try {
            OrderDAO orderDAO = DAOFactory.getInstance().getOrderDAO();
            return orderDAO.getInfoAll();
        } catch (DAOException e) {
            throw new ServiceException("Orders don't exist", e);
        }
    }

    @Override
    public void approve(int idOrder, int idManager) throws ServiceException {
        try {
            OrderDAO orderDAO = DAOFactory.getInstance().getOrderDAO();
            orderDAO.approve(idOrder, idManager);
        } catch (DAOException e) {
            throw new ServiceException("Can't approve the order", e);
        }
    }

    @Override
    public void payment(int idOrder) throws ServiceException {
        try {
            OrderDAO orderDAO = DAOFactory.getInstance().getOrderDAO();
            orderDAO.payment(idOrder);
        } catch (DAOException e) {
            throw new ServiceException("Can't pay for order", e);
        }
    }

    @Override
    public void deleteOrder(int idOrder) throws ServiceException {
        try {
            OrderDAO orderDAO = DAOFactory.getInstance().getOrderDAO();
            orderDAO.deleteOrder(idOrder);
        } catch (DAOException e) {
            throw new ServiceException("Error while deleting order", e);
        }
    }

    @Override
    public void giveCarCustomer(int idOrder) throws ServiceException {
        try {
            OrderDAO orderDAO = DAOFactory.getInstance().getOrderDAO();
            orderDAO.giveCarCustomer(idOrder);
        } catch (DAOException e) {
            throw new ServiceException("Can't change the return status", e);
        }
    }

    @Override
    public void registerReturn(int needRepair, int repairPrice, String description, int idOrder) throws ServiceException {

        if (!validator.priceValidation(repairPrice)) {
            throw new ServiceException("Incorrect Repair price format");
        }
        try {
            OrderDAO orderDAO = DAOFactory.getInstance().getOrderDAO();
            orderDAO.registerReturn(needRepair, repairPrice, description, idOrder);
        } catch (DAOException e) {
            throw new ServiceException("Can't register a return", e);
        }
    }

    @Override
    public void cancelOrderByManager(String description, int idOrder) throws ServiceException {
        try {
            OrderDAO orderDAO = DAOFactory.getInstance().getOrderDAO();
            orderDAO.cancelOrderByManager(description, idOrder);
        } catch (DAOException e) {
            throw new ServiceException("Can't cancel the order by manager", e);
        }
    }
}
