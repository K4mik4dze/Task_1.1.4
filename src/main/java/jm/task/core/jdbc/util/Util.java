package jm.task.core.jdbc.util;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.sql.*;

public class Util {
    private static final String DBTYPE = "jdbc:mysql://";
    private static final String HOSTNAME = "localhost:";
    private static final String PORT = "3306/";
    private static final String NAME = "task113?";
    private static final String SSL = "useSSL=false";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "Kingobiloba@61bb";
    private static  final StringBuilder URL = new StringBuilder(DBTYPE).append(HOSTNAME).
            append(PORT).append(NAME).append(SSL);
    private static SessionFactory sessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();
            sessionFactory = configuration.buildSessionFactory();
        } catch (Throwable e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void registerDriver() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection startConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL.toString(), LOGIN, PASSWORD);
        } catch (SQLException throwables) {
            System.out.println("Ошибка установления соединения с базой данных!");
            throwables.printStackTrace();
        }
        return connection;
    }

    public static Statement getStatement(Connection connection) {
        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException throwables) {
            System.out.println("Ошибка создания statement!");
            throwables.printStackTrace();
        }
        return statement;
    }

    public static void closeConnections(Statement statement, Connection connection) {
        try {
            statement.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}