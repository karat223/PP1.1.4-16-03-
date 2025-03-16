package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("Denis", "Denisov", (byte) 33);
        userService.saveUser("Vasy", "Vasev", (byte) 21);
        userService.saveUser("Sergey", "Sergeev", (byte) 53);
        userService.saveUser("Katy", "Velikay", (byte) 50);
        userService.getAllUsers().forEach(System.out::println);
        userService.dropUsersTable();
    }
}
