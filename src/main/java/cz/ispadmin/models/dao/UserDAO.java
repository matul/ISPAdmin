package cz.ispadmin.models.dao;

import cz.ispadmin.entities.*;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

/**
 * Base model class for operations with data sources
 *
 * @author Roman
 */
@Service
public class UserDAO extends DAO {

  /**
   * Returns a user by ID
   *
   * @param userId
   * @return Users
   */
  public Users getUserById(int userId) {
    Session s = this.sessionFactory.openSession();
    try {
      return (Users) s.get(Users.class, userId);
    } catch (HibernateException e) {
      return null;
    } finally {
      s.close();
    }
  }

  public Users getUserByUsername(String username) {
    Session s = this.sessionFactory.openSession();
    try {
      Query query = s.createQuery("from Users where username = :username");
      query.setParameter("username", username);
      return (Users)query.list().get(0);
    } catch (HibernateException e) {
      return null;
    } finally {
      s.close();
    }
  }
  
  public List<Users> getAllUsers() {
    Session s = this.sessionFactory.openSession();
    try {
      Query query = s.createQuery("from Users");
      List<Users> users = query.list();
      return users;
    } catch (HibernateException e) {
      return null;
    } finally {
      s.close();
    }
  }

  /**
   * Creates or updates a user
   *
   * @param user
   * @return boolean TRUE on success otherwise FALSE
   */
  public boolean insertOrUpdateUser(Users user) {
    Session s = this.sessionFactory.openSession();
    Transaction tx = s.beginTransaction();
    try {
      s.saveOrUpdate(user);
      tx.commit();
      return true;
    } catch (HibernateException e) {
      tx.rollback();
      return false;
    } finally {
      s.close();
    }
  }

  /**
   * Deletes a user by ID
   *
   * @param user
   * @return boolean TRUE on success otherwise FALSE
   */
  public boolean deleteUser(Users user) {
    Session s = this.sessionFactory.openSession();
    Transaction tx = s.beginTransaction();
    try {
      s.delete(user);
      tx.commit();
      return true;
    } catch (HibernateException e) {
      tx.rollback();
      return false;
    } finally {
      s.close();
    }
  }

}
