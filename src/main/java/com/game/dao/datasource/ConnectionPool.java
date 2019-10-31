package com.game.dao.datasource;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConnectionPool {

    private static final ResourceBundle DATABASE_PROPERTIES = ResourceBundle.getBundle("database");

    private static ConnectionPool instance;
    private DataSource dataSource;

    private ConnectionPool() {
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUsername(DATABASE_PROPERTIES.getString("db.connection.user"));
        basicDataSource.setPassword(DATABASE_PROPERTIES.getString("db.connection.password"));
        basicDataSource.setDriverClassName(DATABASE_PROPERTIES.getString("db.connection.driver"));
        basicDataSource.setUrl(DATABASE_PROPERTIES.getString("db.connection.datasource.url"));
        dataSource = basicDataSource;
    }

    public static ConnectionPool getInstance() {
        if (instance == null) {
            synchronized (ConnectionPool.class) {
                if (instance == null) {
                    instance = new ConnectionPool();
                }
            }
        }
        return instance;
    }

    public Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}