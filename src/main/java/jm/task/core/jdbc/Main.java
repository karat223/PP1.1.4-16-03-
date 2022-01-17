package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        User Denis = new User("Denis", "Denisov", (byte) 33);
        User Vasy = new User("Vasy", "Vasev", (byte) 21);
        User Sergey = new User("Sergey", "Sergeev", (byte) 53);
        User Katy = new User("Katy", "Velikay", (byte) 50);
        UserServiceImpl userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser(Denis.getName(), Denis.getLastName(), Denis.getAge());
        userService.saveUser(Vasy.getName(), Vasy.getLastName(), Vasy.getAge());
        userService.saveUser(Sergey.getName(), Sergey.getLastName(), Sergey.getAge());
        userService.saveUser(Katy.getName(), Katy.getLastName(), Katy.getAge());
        userService.getAllUsers().forEach(System.out::println);
        userService.dropUsersTable();
    }
}
