package by.ivanchenko.carrental.dao;
import by.ivanchenko.carrental.bean.user.User;

public interface UserDAO{
     public User logIn(String email, String password) throws DAOException;    // эти данные надо в сессию ложить + id, role.    не надо возвращать  User
     public void registration(User user) throws DAOException;
     public void updateInfo(User user) throws DAOException;
     public void delete(String email) throws DAOException;
//     public void read(User user) throws DAOException;

}
