/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.ispadmin.models.dao;

import cz.ispadmin.entities.Services;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

/**
 *
 * @author Honza
 */
@Service
public class ServicesDAO extends DAO {

  /**
   * Returns a service by ID
   * @param ServicesId
   * @return Services
   */
  public Services getServicesById(int ServicesId) {
    Session d = this.sessionFactory.openSession();
    try {
      return (Services) d.get(Services.class, ServicesId);
    } catch (HibernateException e) {
      return null;
    } finally {
      d.close();
    }
  }

  public List<Services> getAllServices() {
    Session s = this.sessionFactory.openSession();
    try {
      Query query = s.createQuery("from Services");
      List<Services> services = query.list();
      return services;
    } catch (HibernateException e) {
      return null;
    } finally {
      s.close();
    }
  }

  /**
   * Deletes a device by ID
   * @param Service
   * @return boolean TRUE on success otherwise FALSE
   */
  public boolean deleteServices(Services service) {
    Session s = this.sessionFactory.openSession();
    Transaction tx = s.beginTransaction();
    try {
      s.delete(service);
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
   * Creates or updates a device
   *
   * @param service
   * @return boolean TRUE on success otherwise FALSE
   */
  public boolean insertOrUpdateService(Services service) {
    Session s = this.sessionFactory.openSession();
    Transaction tx = s.beginTransaction();
    try {
      s.saveOrUpdate(service);
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
