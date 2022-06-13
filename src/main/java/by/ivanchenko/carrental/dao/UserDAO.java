package by.ivanchenko.carrental.dao;
import by.ivanchenko.carrental.bean.user.User;

public interface UserDAO {
    void logIn(String login, String password);    // эти данные надо в сессию ложить + id, role.    не надо возвращать  User
    void registration(String name, String surname, String phone, String login, String password, String email, int idRole);
    void delete(int idUser);
}
