package by.ivanchenko.carrental.dao.impl;

import by.ivanchenko.carrental.bean.user.User;
import by.ivanchenko.carrental.dao.UserDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserDAOImpl implements UserDAO {

    //public final static String     SQL команды для PreparedStatement




    User user = null;

    Connection connection = null;
    Statement statement = null;
   // ConnectionPool connecctionPool = nnull;git
    ResultSet resultSet = null;
    PreparedStatement preparedStatement = null;





    @Override
    public void logIn(String login, String password) {

    }

    @Override
    public void registration(String name, String surname, String phone, String login, String password, String email, int idRole) {

    }

    @Override
    public void delete(int idUser) {

    }
}
