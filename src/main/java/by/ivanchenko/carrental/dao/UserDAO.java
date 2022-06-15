package by.ivanchenko.carrental.dao;
import by.ivanchenko.carrental.bean.user.User;
import by.ivanchenko.carrental.dao.exception.DAOException;

public interface UserDAO {
     public User logIn(String email, String password) throws DAOException;    // эти данные надо в сессию ложить + id, role.    не надо возвращать  User
     public  void registration(String name, String surname, String phone, String password, String email) throws DAOException;
     public void delete(int idUser);
}
