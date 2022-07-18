package by.ivanchenko.carrental.dao;
import by.ivanchenko.carrental.bean.user.User;

public interface UserDAO{
      User logIn(String email, String password) throws DAOException;    // эти данные надо в сессию ложить + id, role.    не надо возвращать  User
      void registration(User user) throws DAOException;
      void updateInfo(User user) throws DAOException;
      void delete(User user) throws DAOException;

}
