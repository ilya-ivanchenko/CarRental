package by.ivanchenko.carrental.dao;
import by.ivanchenko.carrental.bean.user.User;

import java.util.List;

public interface UserDAO{
      User logIn(String email, String password) throws DAOException;    // эти данные надо в сессию ложить + id, role.    не надо возвращать  User
      void registration(User user) throws DAOException;
      void updateInfo(User user) throws DAOException;
      void delete(int idUser) throws DAOException;
      List<User> allUserInfo() throws DAOException;

}
