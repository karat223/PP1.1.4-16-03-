package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.List;


public class UserDaoHibernateImpl implements UserDao {

    Util util = new Util();

    public UserDaoHibernateImpl() {

    }

    @Override
    public void createUsersTable() {
        Session session = util.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        String sql = "CREATE TABLE IF NOT EXISTS table_users (id SERIAL PRIMARY KEY, name VARCHAR(255), lastName VARCHAR(255), age SMALLINT)";
        Query query = session.createSQLQuery(sql);
        query.executeUpdate();
        session.close();
        System.out.println("Table created");
    }

    @Override
    public void dropUsersTable() {
        Session session = util.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        String sql = "DROP TABLE IF EXISTS table_users";
        Query query = session.createSQLQuery(sql);
        query.executeUpdate();
        session.close();
        System.out.println("Table dropped");
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        Session session = util.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        String sql = "INSERT INTO table_users (name, lastName, age) VALUES (?, ?, ?)";
        Query query = session.createSQLQuery(sql);
        query.setParameter(1, name);
        query.setParameter(2, lastName);
        query.setParameter(3, age);
        query.executeUpdate();
        session.close();
    }

    @Override
    public void removeUserById(long id) {
        Session session = util.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        String sql = "DELETE FROM table_users WHERE id = ?";
        Query query = session.createSQLQuery(sql);
        query.setParameter(1, id);
        query.executeUpdate();
        session.close();
        System.out.println("User with id " + id + " removed");
    }

    @Override
    public List<User> getAllUsers() {
        Session session = util.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        String sql = "SELECT * FROM table_users";
        Query query = session.createSQLQuery(sql);
        List<User> userList = query.getResultList();
        List users = userList.stream().toList();
        session.close();
        return users;
    }

    @Override
    public void cleanUsersTable() {
        Session session = util.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        String sql = "TRUNCATE TABLE table_users";
        Query query = session.createSQLQuery(sql);
        query.executeUpdate();
        session.close();
        System.out.println("Table cleaned");

    }
}
