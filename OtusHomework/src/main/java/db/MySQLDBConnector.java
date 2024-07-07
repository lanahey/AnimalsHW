package db;

import config.DBConfigurator;

import java.sql.*;
import java.util.Properties;

public class MySQLDBConnector implements IDBConnector{

    private DBConfigurator dbConfigurator = new DBConfigurator();

    private static Statement statement = null;
    private static Connection connection = null;

    {
        connect();
    }

    private void connect(){
        try {
            System.out.println("Connect DB");
            Properties configuration = dbConfigurator.getDBConfig();
            if(connection == null) {
                try {
                    connection = DriverManager.getConnection(
                            String.format("jdbc:mysql://%s:%s@%s/%s",
                                    configuration.getProperty("username"),
                                    configuration.getProperty("password"),
                                    configuration.getProperty("db_url"),
                                    configuration.getProperty("db_name")
                            )
                    );
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(statement == null) {
                System.out.println("Create statement");
                statement = connection.createStatement();
            }
        } catch (Exception e){
            System.out.println("Ошибка подключения к базе данных");
            System.out.println(e);
        }
    }

    @Override
    public boolean execute(String sql) throws SQLException {
        return statement.execute(sql);
    }

    @Override
    public ResultSet executeQuery(String sql) throws SQLException {
        return statement.executeQuery(sql);
    }

    @Override
    public void close() throws SQLException {
        if(statement != null) {
            statement.close();
        }
        if(connection != null) {
            connection.close();
        }
    }
}
