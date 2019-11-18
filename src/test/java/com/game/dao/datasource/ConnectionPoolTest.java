package com.game.dao.datasource;

import org.junit.Test;

import java.sql.Connection;

import static org.junit.Assert.assertTrue;

public class ConnectionPoolTest {

    private final ConnectionPool connectionPool = new ConnectionPool("database");

    @Test
    public void getConnectionShouldReturnConnection() {
        assertTrue(connectionPool.getConnection() instanceof Connection);
    }
}