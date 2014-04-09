/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.ispadmin.models.dao;

import cz.ispadmin.entities.Devices;
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
public class DevicesDAO extends DAO {

    /**
   * Returns a user by ID
   */
  public Devices getDevicesById(int DevicesId) {
    Session d = this.sessionFactory.openSession();
    try {
      return (Devices) d.get(Devices.class, DevicesId);
    } catch (HibernateException e) {
      return null;
    } finally {
      d.close();
    }
  }
  
  public List<Devices> getAllDevices() {
    Session s = this.sessionFactory.openSession();
    try {
        Query query = s.createQuery("from Devices");
        List<Devices> devices = query.list();
        return devices;
    } catch (HibernateException e) {
        return null;
    } finally {
        s.close();
    }
  }

  /**
   * Deletes a user by ID
   * @param device
   * @return boolean TRUE on success otherwise FALSE
   */
  public boolean deleteDevice(Devices device) {
    Session s = this.sessionFactory.openSession();
    Transaction tx = s.beginTransaction();
    try {
      s.delete(device);
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
