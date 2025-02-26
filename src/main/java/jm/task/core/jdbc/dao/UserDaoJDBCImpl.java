package jm.task.core.jdbc.dao;

public class UserDaoJDBCImpl {
    public UserDaoJDBCImpl() {

    }

//    public void createUsersTable() {
//        String sql = "CREATE TABLE IF NOT EXISTS users (id BIGINT AUTO_INCREMENT PRIMARY KEY, " +
//                "name VARCHAR(100), lastName VARCHAR(100), age TINYINT)";
//        try (Connection connection = Util.getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    public void dropUsersTable() {
//        String sql = "DROP TABLE IF EXISTS users";
//        try (Connection connection = Util.getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(sql)){
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    public void saveUser(String name, String lastName, byte age) {
//        String sql = "INSERT INTO users (name, lastName, age) VALUES (?,?,?)";
//        try (Connection connection = Util.getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(sql)){
//
//            preparedStatement.setString(1, name);
//            preparedStatement.setString(2, lastName);
//            preparedStatement.setByte(3, age);
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }

//    public void removeUserById(long id) {
//        String sql = "DELETE FROM users WHERE ID=?";
//        try (Connection connection = Util.getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(sql)){
//            preparedStatement.setLong(1, id);
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }

    //public List<User> getAllUsers() {
//        List<User> list = new ArrayList<>();
//        String sql = "SELECT * FROM users";
//        try (Connection connection = Util.getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(sql);
//             ResultSet a = preparedStatement.executeQuery()){
//            while (a.next()) {
//                long b = a.getLong("id");
//                String c = a.getString("name");
//                String d = a.getString("lastName");
//                byte f = a.getByte("age");
//                User user = new User(c, d , f);
//                user.setId(b);
//                list.add(user);
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return list;
//    }

//    public void cleanUsersTable() {
//        String sql = "TRUNCATE users";
//        try (Connection connection = Util.getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(sql)){
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
}
