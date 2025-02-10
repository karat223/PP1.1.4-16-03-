package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {

    Util util = new Util();
    Connection connection = util.getConnection();
    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() throws SQLException {
        PreparedStatement ps = null;
        String sql = "CREATE TABLE IF NOT EXISTS table_users (id SERIAL PRIMARY KEY, name VARCHAR(255), lastName VARCHAR(255), age SMALLINT)" ;
        try {
            ps = connection.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e){
            System.err.println("Connection failed: " + e.getMessage());
        } finally {
            if(ps != null) {ps.close();}
            //if(connection != null) {connection.close();}
        }
    }

    public void dropUsersTable() throws SQLException{
        PreparedStatement ps = null;
        String sql = "DROP TABLE table_users";
        try{
            ps = connection.prepareStatement(sql);
            ps.executeUpdate();
        }catch (SQLException e){
            System.err.println("Connection failed: " + e.getMessage());
        } finally {
            if(ps != null) {ps.close();}
            //if(connection != null) {connection.close();}
        }
    }

    public void saveUser(String name, String lastName, byte age) throws SQLException {
        PreparedStatement ps = null;
        String sql = "INSERT INTO table_users (name, lastName, age) VALUES (?, ?, ?)";
        try{
            ps = connection.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, lastName);
            ps.setByte(3, age);
            ps.executeUpdate();
        }
        catch (SQLException e) {
            System.err.println("Connection failed: " + e.getMessage());
        } finally {
            if(ps != null) {ps.close();}
            //if(connection != null) {connection.close();}
        }
    }

   public void removeUserById(long id) throws SQLException{
        PreparedStatement ps = null;
        String sql = "DELETE FROM table_users WHERE id = ?";
        User user = new User();
        try{
            ps = connection.prepareStatement(sql);
            ps.setLong(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Connection failed: " + e.getMessage());
        } finally {
            if(ps != null) {ps.close();}
            //if(connection != null) {connection.close();}
        }
    }

    public List<User> getAllUsers() throws SQLException{
        Statement statement = null;
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM table_users";
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                User user = new User();
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("lastName"));
                user.setAge(resultSet.getByte("age"));

                users.add(user);
            }
        } catch (SQLException e) {
            System.err.println("Connection failed: " + e.getMessage());
        } finally {
            if(statement != null) {statement.close();}
            //if(connection != null) {connection.close();}
        }
        return users;
    }

    public void cleanUsersTable() throws SQLException{
        PreparedStatement ps = null;
        String sql = "TRUNCATE TABLE table_users";
        try{
            ps = connection.prepareStatement(sql);
            ps.executeUpdate();
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        } finally {
            if(ps!=null){ps.close();}
            //if (connection!=null){connection.close();}
        }
    }
}
