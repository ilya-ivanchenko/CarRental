package by.ivanchenko.carrental.dao.impl.connection;


import java.sql.*;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;

public final class ConnectionPool {    // final ?
    private BlockingQueue<Connection> freeConnectionQueue;
    private BlockingQueue<Connection> givenConnectionQueue;

    /*
Реализация данного интерфейса BlockingQueue обеспечивает блокировку потока в двух случаях :
    при попытке получения элемента из пустой очереди;
    при попытке размещения элемента в полной очереди.
Когда поток пытается получить элемент из пустой очереди, то он переводится в состояние ожидания до тех пор,
пока какой-либо другой поток не разместит элемент в очереди. Аналогично при попытке положить элемент в полную
очередь; поток ставится в ожидание до тех пор, пока другой поток не заберет элемент из очереди и, таким образом,
не освободит место в ней.
     */

    private  String driver;
    private  String url;
    private  String user;
    private  String password;
    private  int poolSize;
    private int defaultPoolSize = 5;

     private static ConnectionPool instance;    //  volatile ?


    private ConnectionPool() throws ConnectionPoolException{                                                           //private ? or public
        DBResourseManager dbResourceManager = DBResourseManager.getInstance();
        this.driver = dbResourceManager.getValue(DBParameter.DRIVER);
        this.url = dbResourceManager.getValue(DBParameter.URL);
        this.user = dbResourceManager.getValue(DBParameter.USER);
        this.password = dbResourceManager.getValue(DBParameter.PASSWORD);
        try {
            this.poolSize = Integer.parseInt(dbResourceManager.getValue(DBParameter.POOLSIZE));
        } catch (NumberFormatException e) {
            poolSize = defaultPoolSize;
        }
        initPool();
    }

    public static ConnectionPool getInstance()  {
        if(instance == null) {
            try {
                instance = new ConnectionPool();
            } catch (ConnectionPoolException e) {
                //  logger.log(Level.ERROR, "Can't create ConnectionPool", e);
                //exception?
            }
        }
        return instance;
    }

    public void initPool() throws ConnectionPoolException {
        try {
            Class.forName(driver);
            givenConnectionQueue = new ArrayBlockingQueue<Connection>(poolSize);
            freeConnectionQueue = new ArrayBlockingQueue<Connection>(poolSize);
            for (int i = 0; i < poolSize; i++) {
                Connection connection = DriverManager.getConnection(url, user, password);
                PooledConnection pooledConnection = new PooledConnection(connection);
                freeConnectionQueue.add(pooledConnection);
            }
        } catch (SQLException e) {
            //log ?
            throw new ConnectionPoolException("SQLException in intializing ConnectinPool", e);
        } catch (ClassNotFoundException e) {
            //log ?
            throw new ConnectionPoolException("Can't find database driver class", e);
        }
    }

    public void dispose() {
        clearConnectionQueue();
    }

    private void clearConnectionQueue() {
        try {
            closeConnectionQueue(givenConnectionQueue);
            closeConnectionQueue(freeConnectionQueue);
        } catch (SQLException e) {   // or InterruptedException ?
           // logger.log(Level.ERROR, "Error closing the connection.", e);
        }
    }

    public Connection takeConnection() throws ConnectionPoolException {
        Connection connection = null;
        try {
            connection = freeConnectionQueue.take();
            givenConnectionQueue.add(connection);
        } catch (InterruptedException e) {
            // log ?
            throw new ConnectionPoolException("Error connecting to  the data source", e);
        }
        return connection;
    }


    public void closeConnection(Connection con, Statement st, ResultSet rs) {
        try {
            rs.close();
        } catch (SQLException e) {
            //logger.log(Level.ERROR, "ResultSet isn't closed", e);
        }
        try {
            st.close();
        } catch(SQLException e) {
            //logger.log(Level.ERROR, "Statement isn't closed", e);
        }
        try {
            con.close();
        } catch (SQLException e) {
            //logger.log(Level.ERROR, "Connection isn't return to the pool", e);    e  передаем или только  message ?
        }
    }

    public void closeConnection(Connection con, Statement st) {
        try {
            st.close();
        } catch(SQLException e) {
            //logger.log(Level.ERROR, "Statement isn't closed", e);
        }
        try {
            con.close();
        } catch (SQLException e) {
            //logger.log(Level.ERROR, "Connection isn't return to the pool", e);    e  передаем или только  message ?
        }
    }

    private void closeConnectionQueue(BlockingQueue<Connection> queue) throws SQLException {
        Connection connection;
        while ((connection = queue.poll()) != null) {     // возвращает с удалением элемент из начала очереди. Если очередь пуста, возвращает значение null
            if (!connection.getAutoCommit()) {
                connection.commit();                       // фиксируем все изменения
            }
            ((PooledConnection) connection).reallyClose();  // см ниже
        }
    }

    private class PooledConnection implements Connection {          // вложенный
        private Connection  connection;

        public PooledConnection (Connection con) throws SQLException {
            this.connection = con;
            this.connection.setAutoCommit(true);
        }

        public void reallyClose() throws SQLException {
            connection.close();
        }

        @Override
        public void clearWarnings() throws SQLException {           // очищает все предупреждения на этом объекте
            connection.clearWarnings();
        }

        @Override
        public  void close() throws SQLException {
            if (connection.isClosed()) {
                throw new SQLException("Attempt to close closed connection.");
            }
            if (connection.isReadOnly()) {
                connection.setReadOnly(false);
            }
            if (!givenConnectionQueue.remove(this)) {
                throw new SQLException("Error deleting connection from the given away connection pool.");
            }
            if (!freeConnectionQueue.remove(this)) {
                throw new SQLException("Error allocating connection in the pool.");
            }
        }

        @Override
        public void commit() throws SQLException {
            connection.commit();
        }

        @Override
        public Statement createStatement() throws SQLException {
            return connection.createStatement();
        }

        @Override
        public PreparedStatement prepareStatement(String sql) throws SQLException {
            return connection.prepareStatement(sql);
        }

        @Override
        public CallableStatement prepareCall(String sql) throws SQLException {
            return connection.prepareCall(sql);
        }

        @Override
        public String nativeSQL(String sql) throws SQLException {
            return connection.nativeSQL(sql);
        }

        @Override
        public void setAutoCommit(boolean autoCommit) throws SQLException {
            connection.setAutoCommit(autoCommit);
        }

        @Override
        public boolean getAutoCommit() throws SQLException {
            return connection.getAutoCommit();
        }

        @Override
        public void rollback() throws SQLException {
            connection.rollback();
        }

        @Override
        public boolean isClosed() throws SQLException {
            return connection.isClosed();
        }

        @Override
        public DatabaseMetaData getMetaData() throws SQLException {
            return connection.getMetaData();
        }

        @Override
        public void setReadOnly(boolean readOnly) throws SQLException {
            connection.setReadOnly(readOnly);
        }

        @Override
        public boolean isReadOnly() throws SQLException {
            return connection.isReadOnly();
        }

        @Override
        public void setCatalog(String catalog) throws SQLException {
            connection.setCatalog(catalog);
        }

        @Override
        public String getCatalog() throws SQLException {
            return connection.getCatalog();
        }

        @Override
        public void setTransactionIsolation(int level) throws SQLException {
            connection.setTransactionIsolation(level);
        }

        @Override
        public int getTransactionIsolation() throws SQLException {
            return connection.getTransactionIsolation();
        }

        @Override
        public SQLWarning getWarnings() throws SQLException {
            return connection.getWarnings();
        }

        @Override
        public Statement createStatement(int resultSetType, int resultSetConcurrency) throws SQLException {
            return connection.createStatement(resultSetType, resultSetConcurrency);
        }

        @Override
        public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency) throws SQLException {
            return connection.prepareStatement(sql, resultSetType,resultSetConcurrency);
        }

        @Override
        public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency) throws SQLException {
            return connection.prepareCall(sql, resultSetType, resultSetConcurrency);
        }

        @Override
        public Map<String, Class<?>> getTypeMap() throws SQLException {
            return connection.getTypeMap();
        }

        @Override
        public void setTypeMap(Map<String, Class<?>> map) throws SQLException {
            connection.setTypeMap(map);
        }

        @Override
        public void setHoldability(int holdability) throws SQLException {
            connection.setHoldability(holdability);
        }

        @Override
        public int getHoldability() throws SQLException {
            return connection.getHoldability();
        }

        @Override
        public Savepoint setSavepoint() throws SQLException {
            return connection.setSavepoint();
        }

        @Override
        public Savepoint setSavepoint(String name) throws SQLException {
            return connection.setSavepoint(name);
        }

        @Override
        public void rollback(Savepoint savepoint) throws SQLException {
            connection.rollback(savepoint);
        }

        @Override
        public void releaseSavepoint(Savepoint savepoint) throws SQLException {
            connection.releaseSavepoint(savepoint);
        }

        @Override
        public Statement createStatement(int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
            return connection.createStatement(resultSetType, resultSetConcurrency,resultSetHoldability);
        }

        @Override
        public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
            return connection.prepareStatement(sql, resultSetType,resultSetConcurrency, resultSetHoldability);
        }

        @Override
        public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
            return connection.prepareCall(sql, resultSetType, resultSetConcurrency, resultSetHoldability);
        }

        @Override
        public PreparedStatement prepareStatement(String sql, int autoGeneratedKeys) throws SQLException {
            return connection.prepareStatement(sql, autoGeneratedKeys);
        }

        @Override
        public PreparedStatement prepareStatement(String sql, int[] columnIndexes) throws SQLException {
            return connection.prepareStatement(sql, columnIndexes);
        }

        @Override
        public PreparedStatement prepareStatement(String sql, String[] columnNames) throws SQLException {
            return connection.prepareStatement(sql,columnNames);
        }

        @Override
        public Clob createClob() throws SQLException {
            return connection.createClob();
        }

        @Override
        public Blob createBlob() throws SQLException {
            return connection.createBlob();
        }

        @Override
        public NClob createNClob() throws SQLException {
            return connection.createNClob();
        }

        @Override
        public SQLXML createSQLXML() throws SQLException {
            return connection.createSQLXML();
        }

        @Override
        public boolean isValid(int timeout) throws SQLException {
            return connection.isValid(timeout);
        }

        @Override
        public void setClientInfo(String name, String value) throws SQLClientInfoException {
            connection.setClientInfo(name,value);
        }

        @Override
        public void setClientInfo(Properties properties) throws SQLClientInfoException {
            connection.setClientInfo(properties);
        }

        @Override
        public String getClientInfo(String name) throws SQLException {
            return connection.getClientInfo(name);
        }

        @Override
        public Properties getClientInfo() throws SQLException {
            return connection.getClientInfo();
        }

        @Override
        public Array createArrayOf(String typeName, Object[] elements) throws SQLException {
            return connection.createArrayOf(typeName, elements);
        }

        @Override
        public Struct createStruct(String typeName, Object[] attributes) throws SQLException {
            return connection.createStruct(typeName, attributes);
        }

        @Override
        public void setSchema(String schema) throws SQLException {
            connection.setSchema(schema);
        }

        @Override
        public String getSchema() throws SQLException {
            return connection.getSchema();
        }

        @Override
        public void abort(Executor executor) throws SQLException {
            connection.abort(executor);
        }

        @Override
        public void setNetworkTimeout(Executor executor, int milliseconds) throws SQLException {
            connection.setNetworkTimeout(executor, milliseconds);
        }

        @Override
        public int getNetworkTimeout() throws SQLException {
            return connection.getNetworkTimeout();
        }

        @Override
        public <T> T unwrap(Class<T> iface) throws SQLException {
            return connection.unwrap(iface);
        }

        @Override
        public boolean isWrapperFor(Class<?> iface) throws SQLException {
            return connection.isWrapperFor(iface);
        }
    }
}








