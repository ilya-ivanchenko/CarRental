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
      try {
          UserDAO userDAO = DAOFactory.getInstance().getUserDAO();
          userDAO.registration(user);
      } catch (Exception e) {
          throw new ServiceException("Error while register user",e);
      }
    }

    @Override
    public User authorize(String email, String password) throws ServiceException {
//validation ADD
if (email == null || email.isEmpty()) {
    throw new ServiceException("Incorrect email"); // "User with this e-mail not found"
}
// cессия
        // поверка на авторизован ли уже

        try {
            UserDAO userDAO = DAOFactory.getInstance().getUserDAO();
       User user =  userDAO.logIn(email, password);
//       if (user != null) {
//           return user;
//       } else {
//           return
//       }
            return user;
        } catch (DAOException e) {
            throw new ServiceException("", e);
        }
    }

    @Override
    public void delete(User user) throws ServiceException {

    }
}
