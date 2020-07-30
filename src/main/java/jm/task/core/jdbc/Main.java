package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        UserService userService = new UserServiceImpl();

        userService.createUsersTable();

        userService.saveUser("ivan", "ivanov", (byte) 17);
        userService.saveUser("petr", "petrov", (byte) 18);
        userService.saveUser("sidorov", "sidorov", (byte) 19);
        userService.saveUser("pavel", "pavlov", (byte) 20);

        users = userService.getAllUsers();
        for (User user : users) {
            System.out.println(user);
        }

        userService.removeUserById(3);
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}