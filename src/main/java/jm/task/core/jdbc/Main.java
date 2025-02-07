package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        Util util = new Util();
        UserServiceImpl userImpl = new UserServiceImpl();
        byte ageBy = 5;
        byte age2 = 7;
        User user = new User("Lea","Nemia", ageBy);
        User user1 = new User("Miu","Miw", age2);
        User user2 = new User("Fio", "Leri", age2);
        User user3 = new User("Rea", "Tirey", ageBy);

        try {userImpl.createUsersTable();
            userImpl.saveUser(user.getName(), user.getLastName(), user.getAge());
            System.out.println(user.toString());
            userImpl.saveUser(user1.getName(), user1.getLastName(), user1.getAge());
            System.out.println(user1.toString());
            userImpl.saveUser(user2.getName(), user2.getLastName(), user2.getAge());
            System.out.println(user2.toString());
            userImpl.saveUser(user3.getName(), user3.getLastName(), user3.getAge());
            System.out.println(user3.toString());
            //System.out.println(userImpl.getAllUsers());
            //userImpl.removeUserById(1);
            //userImpl.cleanUsersTable();
            //userImpl.dropUsersTable();
        }
        catch (Exception e) {e.printStackTrace();}
    }
}
