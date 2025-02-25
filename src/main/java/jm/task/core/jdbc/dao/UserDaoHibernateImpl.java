package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.*;
import org.hibernate.query.Query;

import javax.persistence.Entity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Queue;

public class UserDaoHibernateImpl implements UserDao {
    private static final SessionFactory session = Util.getSessionFactory();
    public UserDaoHibernateImpl() {
    }


    @Override
    public void createUsersTable() {
        String sql = "CREATE TABLE IF NOT EXISTS users " +
                "(id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
                "name VARCHAR(50) NOT NULL, lastName VARCHAR(50) NOT NULL, " +
                "age TINYINT NOT NULL)";
        try (Session session1 = session.getCurrentSession()){
            session1.beginTransaction();
            Query query = session1.createSQLQuery(sql).addEntity(User.class);
            query.executeUpdate();
            session1.getTransaction().commit();
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void dropUsersTable() {
        String sql = "DROP TABLE IF EXISTS users";
        try (Session session1 = session.getCurrentSession()){
            session1.beginTransaction();
            Query query = session1.createSQLQuery(sql).addEntity(User.class);
            query.executeUpdate();
            session1.getTransaction().commit();
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        try (Session session1 = session.getCurrentSession()){
            session1.beginTransaction();
            session1.save(new User(name, lastName, age));
            session1.getTransaction().commit();
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void removeUserById(long id) {
        try (Session session1 = session.getCurrentSession()){
            session1.beginTransaction();
            User user = session1.get(User.class, id);
            session1.delete(user);
            session1.getTransaction().commit();
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> list;
        try (Session session1 = session.getCurrentSession()){
            session1.beginTransaction();
            list = session1.createCriteria(User.class).list();
            session1.getTransaction().commit();
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public void cleanUsersTable() {
        String sql = "TRUNCATE users";
        try (Session session1 = session.getCurrentSession()){
            session1.beginTransaction();
            Query query = session1.createSQLQuery(sql).addEntity(User.class);
            query.executeUpdate();
            session1.getTransaction().commit();
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }
}
