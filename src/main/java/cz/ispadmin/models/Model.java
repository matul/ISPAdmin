package cz.ispadmin.models;

import cz.ispadmin.entities.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Roman
 */
@Service
public class Model {

  private SessionFactory sessionFactory;

  @Autowired
  public void setSessionFactory(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  public void createUser(Users user) {
    Session s = sessionFactory.openSession();
    Transaction tx = s.beginTransaction();
    try {
      s.save(user);
      tx.commit();
    } catch (HibernateException e) {
      tx.rollback();
    } finally {
      s.close();
    }
  }

}
