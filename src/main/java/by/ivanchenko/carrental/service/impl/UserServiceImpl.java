package by.ivanchenko.carrental.service.impl;

import by.ivanchenko.carrental.bean.user.User;
import by.ivanchenko.carrental.dao.DAOException;
import by.ivanchenko.carrental.dao.DAOFactory;
import by.ivanchenko.carrental.dao.UserDAO;
import by.ivanchenko.carrental.service.ServiceException;
import by.ivanchenko.carrental.service.UserService;
import by.ivanchenko.carrental.service.Validator;

public class UserServiceImpl implements UserService {

    private static final Validator validator = new Validator();

    @Override
    public void register(User user) throws ServiceException {

        if (!validator.nameValidation(user.getName())) {
            throw new ServiceException("Incorrect name format. The name must not contain numbers");
        }

        if (!validator.nameValidation(user.getSurname())) {
            throw new ServiceException("Incorrect surname format. The surname must not contain numbers");
        }

        if (!validator.phoneValidation(user.getPhone())) {
            throw new ServiceException("Incorrect phone format. The phone must start with +...");
        }

        if (!validator.emailValidation(user.getEmail())) {
            throw new ServiceException("Incorrect email format");
        }

        try {
          UserDAO userDAO = DAOFactory.getInstance().getUserDAO();
          userDAO.registration(user);
      } catch (DAOException e) {
          throw new ServiceException("Error while register user",e);
      }
    }

    @Override
    public User authorize(String email, String password) throws ServiceException {
        if (!validator.emailValidation(email)) {
            throw new ServiceException("Incorrect email format");   // page?
        }
        // cессия
        // поверка на авторизован ли уже
        try {
            UserDAO userDAO = DAOFactory.getInstance().getUserDAO();
            User user =  userDAO.logIn(email, password);
            return user;
        } catch (DAOException e) {
            throw new ServiceException("User authorization error: incorrect email or wrong password", e);
        }
    }

    @Override
    public void updateInfo(User user) throws ServiceException {

    }

    @Override
    public void delete(User user) throws ServiceException {

    }
}
