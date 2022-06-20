package by.ivanchenko.carrental.dao.transaction;

import java.sql.Connection;

public class TransactionImpl implements Transaction {
    private Connection connection;
    public TransactionImpl(Connection connection) {
        this.connection = connection;
    }

//





    @Override
    public void close() throws Exception {

    }
}
