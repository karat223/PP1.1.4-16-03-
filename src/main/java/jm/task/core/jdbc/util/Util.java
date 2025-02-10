package jm.task.core.jdbc.util;
import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.util.Properties;


import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

public class Util {
    String url = "jdbc:postgresql://localhost:8000/virt_health";
    String user = "postgres";
    String pas = "KiraWi";
    private SessionFactory sessionFactory;
    //var 1
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
    // var 2
    public SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try{
                Configuration configuration = new Configuration();
                Properties settings = new Properties();
                settings.setProperty("hibernate.connection.username", "postgres");
                settings.setProperty("hibernate.connection.password", "KiraWi");
                settings.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
                settings.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:8000/virt_health");
                configuration.setProperties(settings);
                configuration.addAnnotatedClass(User.class); //add JPA entity mapping class
                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
                System.out.println("SessionFactory created successfully.");
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        } return sessionFactory;
    }

}

