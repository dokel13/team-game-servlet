package com.game.dao.datasource;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConnectionPool {

//    private final ResourceBundle DATABASE_PROPERTIES = ResourceBundle.getBundle("database");
    private BasicDataSource dataSource;

    private final ResourceBundle databaseProperties;

    public ConnectionPool(String fileName) {
        databaseProperties = ResourceBundle.getBundle(fileName);
        this.dataSource = new BasicDataSource();
        dataSource.setUsername(databaseProperties.getString("db.connection.user"));
        dataSource.setPassword(databaseProperties.getString("db.connection.password"));
        dataSource.setDriverClassName(databaseProperties.getString("db.connection.driver"));
        dataSource.setUrl(databaseProperties.getString("db.connection.datasource.url"));
    }

    public Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
