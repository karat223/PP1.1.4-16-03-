package jm.task.core.jdbc.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

public class Util {
    String url = "jdbc:postgresql://localhost:8000/virt_health";
    String user = "postgres";
    String pas = "KiraWi";
    // реализуйте настройку соеденения с БД
    public Connection getConnection() {
        Connection connection = null;
        // Попытка подключения
        try {
            connection = DriverManager.getConnection(url, user, pas);
            System.out.println("Connection to PostgreSQL established successfully.");
            // Ваши действия с базой данных
        } catch (SQLException e) {
            System.err.println("Connection failed: " + e.getMessage());
        }
        return connection;
    }
}

