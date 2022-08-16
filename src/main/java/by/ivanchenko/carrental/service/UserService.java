package by.ivanchenko.carrental.service;

import by.ivanchenko.carrental.bean.User;

import java.util.List;

public interface UserService {
    boolean register(User user) throws ServiceException;
    User authorize(String email, char[] password) throws ServiceException;
    void updateInfo(User user) throws ServiceException;
    void delete(int idUser) throws ServiceException;
    List<User> allUserInfo() throws ServiceException;
    User userInfo(int idUser) throws ServiceException;
}
