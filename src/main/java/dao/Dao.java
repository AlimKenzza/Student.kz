package dao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;
import java.util.Collection;

public abstract class Dao<T> {
    protected Connection connection;
    protected ResultSet resultSet;
    protected PreparedStatement pStatement;
    protected String query;

    protected void getConnection() {
        try {
            Context initialContext = new InitialContext();
            Context envCtx = (Context) initialContext.lookup("java:comp/env");
            DataSource ds = (DataSource) envCtx.lookup("jdbc/week");
            connection = ds.getConnection();
        } catch (NamingException | SQLException e) {
            e.printStackTrace();
        }
    }

    public abstract Collection<T> fetch();

    public abstract void add(T o);

    public abstract void edit(T o);

    public abstract void delete(int id);

    public abstract T get(int id);

    protected void closeStatementAndConnection(PreparedStatement statement, Connection connection) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
