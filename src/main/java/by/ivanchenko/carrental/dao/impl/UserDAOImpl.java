package by.ivanchenko.carrental.dao.impl;

import by.ivanchenko.carrental.bean.user.User;
import by.ivanchenko.carrental.dao.UserDAO;
import by.ivanchenko.carrental.dao.exception.DAOException;

import java.sql.*;

public class UserDAOImpl implements UserDAO {

    //public final static String     SQL команды для PreparedStatement
    private static final String ID = "id_user";
    private static final String NAME = "name";
    private static final String SURNAME = "surname";
    private static final String PHONE = "phone";
    private static final String PASSWORD = "password";
    private static final String EMAIL = "email";
    private static final String ROLE = "id_role";


    private static final String REGISTER_USER = "INSERT INTO users ('name', 'surname', 'phone', 'password', 'email', 'id_role') VALUES (?, ?, ?, ?, ?, ?)";
    private static final String DELETE_USER = "DELETE FROM users WHERE 'id_user' = ?";  // или (?)
    //.? ..LOG_IN через SELECT






    @Override
    public User logIn(String email, String password) throws DAOException {    //


            Connection connection = null;
            Statement statement = null;
            // ConnectionPool connecctionPool = null;  git
            ResultSet resultSet = null;
            PreparedStatement preparedStatement = null;

        try {
            // con pool
//            connection =
//                    statement =
//                            resultSet =

            if (!resultSet.next()) {
                return null;
            }
            User user = new User();
            user.setId(resultSet.getInt(1));
            user.setName(resultSet.getString(2));
            user.setSurname(resultSet.getString("surname"));   //either... or ..3
            user.setPhone(resultSet.getString(4));
            user.setPassword(resultSet.getString(5));
            user.setEmail(resultSet.getString(6));
           // user.setRole(resultSet.getInt(8));  role?

            //  to do    con.pool close    код с примера моего   с  finally


        } catch (SQLException e) {  // to do
            throw new DAOException(e);
        } // catch (ConnectionPoolEsception) ?


        return null; // del
    }




    @Override
    // метод сделать synhronized, чтобы одновременно два  одинаковых логина не зарегать
    //метод добавить на  проверку  существующего логина в БД
    public void registration(String name, String surname, String phone, String password, String email, int id_role) throws DAOException { //, int idRole ?
        boolean isRegistration = false;

    // private DaoFactory  daoFactory = DaoFactory.getInstance();    ?



            User user = null;        // need or not
            Connection connection = null;
            Statement statement = null;
            // ConnectionPool connecctionPool = null;  git
            ResultSet resultSet = null;
            PreparedStatement preparedStatement = null;
        try {

            preparedStatement = connection.prepareStatement(REGISTER_USER, Statement.RETURN_GENERATED_KEYS);   // necessary or not Statement.RETURN_GENERATED_KEYS
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,surname);
            preparedStatement.setString(3,phone);
            preparedStatement.setString(4,password);
            preparedStatement.setString(5,email);
            preparedStatement.setInt(6,id_role);

            preparedStatement.executeUpdate();

            resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();  // while?
            user = new User(resultSet.getString("name"), resultSet.getString("surname"),
                    resultSet.getString("phone"), resultSet.getString("password"),
                    resultSet.getString("email"), resultSet.getInt("id"), resultSet.get); ///role ?
            //what about id there?

//            user.setRole(resultSet.getInt("role"));
//            в примере отдельно еще адресс, телефон, id и т.д



//cp.closeConection(connection,statement);
// log.trace  - after closing connection
        } catch (SQLException e) {  // to do      likewise upper 'logIn'
            //log.error("some message", e);
             throw new DAOException(e);   // or  throw new DAOException("message", e);
        } // catch (ConnectionPoolEsception) ?
    }



    @Override
    public void delete(int idUser) {

            Connection connection = null;
            Statement statement = null;
            // ConnectionPool connecctionPool = null;  git
            ResultSet resultSet = null;
            PreparedStatement preparedStatement = null;
        try {
          preparedStatement = connection.prepareStatement(DELETE_USER);
          preparedStatement.setInt(1, idUser);
          preparedStatement.executeUpdate();

        } catch (SQLException e) {
         //   throw new DaoException(e);
        }
    }
}
