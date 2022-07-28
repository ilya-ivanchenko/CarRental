package by.ivanchenko.carrental.service;

import by.ivanchenko.carrental.bean.user.User;
import by.ivanchenko.carrental.dao.DAOException;

import java.util.List;

public interface UserService {
    void register(User user) throws ServiceException;
    User authorize(String email, String password) throws ServiceException;
    void updateInfo(User user) throws ServiceException;
    void delete(int idUser) throws ServiceException;
    List<User> allUserInfo() throws ServiceException;
}
