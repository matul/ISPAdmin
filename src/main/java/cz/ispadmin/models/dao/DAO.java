package cz.ispadmin.models.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Roman
 */
public class DAO { 
  protected SessionFactory sessionFactory;

  /**
   * Injects a SessionFactory object
   * @param sessionFactory
   */
  @Autowired
  public void setSessionFactory(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }
}
