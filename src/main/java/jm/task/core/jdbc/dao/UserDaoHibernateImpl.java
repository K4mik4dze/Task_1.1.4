package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class UserDaoHibernateImpl implements UserDao {

    public UserDaoHibernateImpl() {

    }

    @Override
    public void createUsersTable() {
//        Session session = sessionFactory.openSession();
//        Transaction transaction = null;
//
//        try{
//            transaction = session.beginTransaction();
//            System.out.println("Начали сессию в методе createUsersTable");
//            transaction.commit();
//        }catch(Exception e){
//            if(transaction !=null){
//                transaction.rollback();
//                e.printStackTrace();
//            }
//            e.printStackTrace();
//        }finally{
//            session.close();
//        }
    }

    @Override
    public void dropUsersTable() {

    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
//        Session session = sessionFactory.openSession();
//        Transaction transaction = null;
//
//        try{
//            transaction = session.beginTransaction();
//            System.out.println("Начали сессию в методе saveUser");
//            transaction.commit();
//        }catch(Exception e){
//            if(transaction !=null){
//                transaction.rollback();
//                e.printStackTrace();
//            }
//            e.printStackTrace();
//        }finally{
//            session.close();
//        }
    }

    @Override
    public void removeUserById(long id) {

    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public void cleanUsersTable() {

    }
}
