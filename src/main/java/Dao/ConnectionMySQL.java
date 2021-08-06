package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionMySQL {
    public static Connection getConnect() {
        String jdbcURL = "jdbc:mysql://localhost:3306/module3case?userSSL=false&useUnicode=yes&characterEncoding=UTF-8";
        String jdbcUsername = "root";
        String jdbcPassword = "Kanze9152";
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException a) {
            a.printStackTrace();
        }
        return connection;
    }
}