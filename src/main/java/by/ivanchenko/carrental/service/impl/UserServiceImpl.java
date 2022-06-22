package by.ivanchenko.carrental.service.impl;

import by.ivanchenko.carrental.bean.user.User;
import by.ivanchenko.carrental.dao.DAOException;
import by.ivanchenko.carrental.dao.DAOFactory;
import by.ivanchenko.carrental.dao.UserDAO;
import by.ivanchenko.carrental.service.ServiceException;
import by.ivanchenko.carrental.service.UserService;

public class UserServiceImpl implements UserService {


    //во всех методах проверка входящих параметров быть должна


    @Override
    public void register(User user) throws ServiceException {

    }

    @Override
    public void authorize(String email, String password) throws ServiceException {
//
if (email == null || email.isEmpty()) {
    throw new ServiceException("Incorrect email"); // "User with e-mail not found"
}


        try {
        DAOFactory daoFactory = DAOFactory.getInstance();
        UserDAO userDAO = daoFactory.getUserDAO();
        userDAO.logIn(email, password);
//
        } catch (DAOException e) {
            throw new ServiceException("", e);
        }
        //
    }

    @Override
    public void delete(User user) throws ServiceException {

    }
}
