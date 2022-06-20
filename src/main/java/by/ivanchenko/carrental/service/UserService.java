package by.ivanchenko.carrental.service;

import by.ivanchenko.carrental.bean.user.User;

public interface UserService {
    void register(User user) throws ServiceException;
    void authorize(String email, String password) throws ServiceException;
}
