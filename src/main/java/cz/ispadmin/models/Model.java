package cz.ispadmin.models;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Base model class for operations with data sources
 * @author Roman
 */
@Service
public class Model {

  private SessionFactory sessionFactory;

  /**
   * Injects a SessionFactory object
   * @param sessionFactory 
   */
  @Autowired
  public void setSessionFactory(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }
}
