package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        UserService userDao = new UserServiceImpl();
        userDao.createUsersTable();

        userDao.saveUser("Ivan", "Ivanov", (byte) 41);
        userDao.saveUser("Petr", "Petrov", (byte) 25);
        userDao.saveUser("Elena", "Lenina", (byte) 38);
        userDao.saveUser("Vasia", "Alexandrov", (byte) 11);

        System.out.println(userDao.getAllUsers().toString());

        userDao.cleanUsersTable();
        userDao.dropUsersTable();
    }
}