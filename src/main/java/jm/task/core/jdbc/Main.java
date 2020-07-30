package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static SessionFactory sessionFactory;

//    static {
//        try {
//            Configuration configuration = new Configuration();
//            configuration.configure();
//            sessionFactory = configuration.buildSessionFactory();
//        } catch (Throwable ex) {
//            throw new ExceptionInInitializerError(ex);
//        }
//    }
//
//    public Session getSession() throws HibernateException {
//        return SessionFactory.openSession();
//    }

    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        UserService userService = new UserServiceImpl();
        sessionFactory = new Configuration().configure().buildSessionFactory();

        User user = new User();
        System.out.println("Adding user record to the DB");
        user.addUser(new Long(1), "durak", "durakov", (byte) 20);



//        final Session session = getSession();
//        try {
//            System.out.println("querying all the managed entities...");
//            final Map metadataMap = session.getSessionFactory().getAllClassMetadata();
//            for (Object key : metadataMap.keySet()) {
//                final ClassMetadata classMetadata = (ClassMetadata) metadataMap.get(key);
//                final String entityName = classMetadata.getEntityName();
//                final Query query = session.createQuery("from " + entityName);
//                System.out.println("executing: " + query.getQueryString());
//                for (Object o : query.list()) {
//                    System.out.println("  " + o);
//                }
//            }
//        } finally {
//            session.close();
//        }

//        User user = new User((long) 1, "ivan", "ivanov", (byte) 17);
//        System.out.println(user);
//        int theID = (Integer) session.save(user);

//        userService.createUsersTable();

//        userService.saveUser("ivan", "ivanov", (byte) 17);
//        userService.saveUser("petr", "petrov", (byte) 18);
//        userService.saveUser("sidorov", "sidorov", (byte) 19);
//        userService.saveUser("pavel", "pavlov", (byte) 20);
//
//        users = userService.getAllUsers();
//        for (User user : users) {
//            System.out.println(user);
//        }

//        userService.removeUserById(1);
//        userService.cleanUsersTable();
//        userService.dropUsersTable();
    }
}