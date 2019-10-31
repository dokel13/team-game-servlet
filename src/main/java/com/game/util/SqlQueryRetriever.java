package com.game.util;

import java.util.ResourceBundle;

public class SqlQueryRetriever {

    private static SqlQueryRetriever instance;
    private ResourceBundle resourceBundle;

    private SqlQueryRetriever() {
        resourceBundle = ResourceBundle.getBundle("queries");
    }

    public enum Query {
        SELECT_USER_BY_LOGIN("select.user.by.login"),
        INSERT_USER("insert.user");

        private String key;

        Query(String key) {
            this.key = key;
        }

        public String getKey() {
            return key;
        }
    }

    public static SqlQueryRetriever getInstance() {
        if (instance == null) {
            synchronized (SqlQueryRetriever.class) {
                if(instance == null) {
                    instance = new SqlQueryRetriever();
                }
            }
        }
        return instance;
    }

    public String getQuery(Query query) {
        return resourceBundle.getString(query.getKey());
    }
}
