package by.ivanchenko.carrental.dao;

public class DAOException  extends Exception{
   // private static final long serialVersionUID = ;
    public DAOException() {
        super();
    }

    public DAOException(String message, Exception e) {
        super(message,e);
    }

    public DAOException(String message) {
        super(message);
    }
    public DAOException(Exception e) {
        super(e);
    }


}
