package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

import static jm.task.core.jdbc.util.Util.*;

public class UserDaoHibernateImpl implements UserDao {

    public UserDaoHibernateImpl() {
    }

    @Override
    public void createUsersTable() {
        Session session = getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            Query query = session.createSQLQuery("create table user(id bigint auto_increment primary key, " +
                    "name varchar(30), lastname varchar(30), age tinyint);");
            query.executeUpdate();
            transaction.commit();
            session.close();
            System.out.println("Таблица Юзер создана.");
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
                e.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public void dropUsersTable() {
        Session session = getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            Query query = session.createSQLQuery("DROP TABLE User ");
            query.executeUpdate();
            transaction.commit();
            session.close();
            System.out.println("Таблица удалена");
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
                e.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            User user = new User(name, lastName, age);
            session.save(user);
            transaction.commit();
            session.close();
            System.out.println("Пользователь " + name + " добавлен в БД.");
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
                e.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public void removeUserById(long id) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            Query query = session.createQuery("DELETE FROM User WHERE id = :Id");
            query.setParameter("Id", id);
            int result = query.executeUpdate();
            transaction.commit();
            session.close();
            System.out.println("Блок удаления юзера. Юзер " + id + " удален.");
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
                e.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public List<User> getAllUsers() {
        Session session = getSessionFactory().openSession();
        Transaction transaction = null;
        List<User> list = new ArrayList<>();

        try {
            transaction = session.beginTransaction();
            Query query = session.createQuery("FROM User");
            list = query.list();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
                e.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return list;
    }

    @Override
    public void cleanUsersTable() {
        Session session = getSessionFactory().openSession();
        Transaction transaction = null;
        List<User> list = new ArrayList<>();

        try {
            transaction = session.beginTransaction();
            Query query = session.createQuery("DELETE FROM User");
            int result = query.executeUpdate();
            transaction.commit();
            session.close();
            System.out.println("Блок очистки таблицы от ВСЕХ данных. Удалено "
                    + result + " записи(ей).");
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
                e.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
