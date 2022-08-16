package by.ivanchenko.carrental.dao;
import by.ivanchenko.carrental.bean.User;

import java.util.List;

public interface UserDAO{
      User logIn(String email, char[] password) throws DAOException;    // эти данные надо в сессию ложить + id, role.    не надо возвращать  User
      boolean registration(User user) throws DAOException;
      void updateInfo(User user) throws DAOException;
      void delete(int idUser) throws DAOException;
      List<User> allUserInfo() throws DAOException;
      User userInfo(int idUser) throws DAOException;

}
