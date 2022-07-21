package edu.school21.chat.repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Properties;

public class Db_connection {
    private String url;
    private  Properties properties;
    public Db_connection(String url, Properties prop)
    {
        this.url = url;
        this.properties = prop;
    }

    public Connection getConnection()
    {
        try {
            Connection con = DriverManager.getConnection(url, properties);
            return (con);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
