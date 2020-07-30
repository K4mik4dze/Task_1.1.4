package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {
    }

    public void createUsersTable() {
        Connection connection = Util.startConnection();
        Statement statement = Util.getStatement(connection);
        Util.registerDriver();
        try {
            statement.execute("create table user(id bigint auto_increment primary key, " +
                    "name varchar(30), lastname varchar(30), age tinyint);");
            System.out.println("Таблица успешно создана");
        } catch (SQLException e) {
            System.out.println("Ошибка при создании таблицы user! Таблица уже создана");
            e.printStackTrace();
        } finally {
            Util.closeConnections(statement, connection);
        }
    }

    public void dropUsersTable() {
        Connection connection = Util.startConnection();
        Statement statement = Util.getStatement(connection);
        Util.registerDriver();

        try {
            statement.execute("drop table user");
            System.out.println("Таблица успешно удалена");
        } catch (SQLException e) {
            System.out.println("Ошибка при удалении таблицы user! Таблица не создана!");
            e.printStackTrace();
        } finally {
            Util.closeConnections(statement, connection);
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        Connection connection = Util.startConnection();
        Statement statement = Util.getStatement(connection);
        Util.registerDriver();

        try {
            statement.execute("insert into user (name, lastname, age) values ('" +
                    name + "', '" + lastName + "', " + age + ")");
            System.out.println("User с именем – " + name + " добавлен в базу данных");
        } catch (SQLException e) {
            System.out.println("Ошибка при добавлении юзера!");
            e.printStackTrace();
        } finally {
            Util.closeConnections(statement, connection);
        }
    }

    public void removeUserById(long id) {
        Connection connection = Util.startConnection();
        Statement statement = Util.getStatement(connection);
        Util.registerDriver();

        try {
            statement.execute("DELETE FROM user WHERE id = " + id + ";");
            System.out.println("User с id – " + id + " удален из базы данных");
        } catch (SQLException e) {
            System.out.println("Ошибка при удалении юзера!");
            e.printStackTrace();
        } finally {
            Util.closeConnections(statement, connection);
        }
    }

    public List<User> getAllUsers() {
        Connection connection = Util.startConnection();
        Statement statement = Util.getStatement(connection);
        Util.registerDriver();
        List<User> users = new ArrayList<>();

        try {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM user");

            while (resultSet.next()) {
                Long id = resultSet.getLong(1);
                String name = resultSet.getString("name");
                String lastname = resultSet.getString(3);
                Byte age = resultSet.getByte("age");
                User user = new User(id, name, lastname, age);
                users.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            Util.closeConnections(statement, connection);
        }
        return users;
    }

    public void cleanUsersTable() {
        Connection connection = Util.startConnection();
        Statement statement = Util.getStatement(connection);
        Util.registerDriver();

        try {
            statement.execute("DELETE FROM user");
            System.out.println("Очистка таблицы произведена");
        } catch (SQLException e) {
            System.out.println("Ошибка при очистке таблицы!");
            e.printStackTrace();
        } finally {
            Util.closeConnections(statement, connection);
        }
    }
}