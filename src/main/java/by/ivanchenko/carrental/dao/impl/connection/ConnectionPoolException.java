package by.ivanchenko.carrental.dao.impl.connection;

public class ConnectionPoolException extends Exception{

    public ConnectionPoolException(String message, Exception e) {
        super(message, e);
    }
}
