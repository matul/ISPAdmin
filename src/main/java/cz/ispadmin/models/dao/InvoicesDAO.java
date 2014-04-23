/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.ispadmin.models.dao;

import cz.ispadmin.entities.Invoices;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

/**
 *
 * @author Maya
 */
@Service
public class InvoicesDAO extends DAO {

  /**
   * Returns a invoice by ID
   * @param InvoicesId
   * @return Invoices
   */
  public Invoices getInvoicesById(int InvoicesId) {
    Session d = this.sessionFactory.openSession();
    try {
      return (Invoices) d.get(Invoices.class, InvoicesId);
    } catch (HibernateException e) {
      return null;
    } finally {
      d.close();
    }
  }

  public List<Invoices> getAllInvoices() {
    Session s = this.sessionFactory.openSession();
    try {
      Query query = s.createQuery("from Invoices");
      List<Invoices> invoices = query.list();
      return invoices;
    } catch (HibernateException e) {
      return null;
    } finally {
      s.close();
    }
  }

  /**
   * Deletes a invoice by ID
   * @param invoice
   * @return boolean TRUE on success otherwise FALSE
   */
  public boolean deleteInvoice(Invoices invoice) {
    Session s = this.sessionFactory.openSession();
    Transaction tx = s.beginTransaction();
    try {
      s.delete(invoice);
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
   * Creates or updates a invoice
   *
   * @param invoice
   * @return boolean TRUE on success otherwise FALSE
   */
  public boolean insertOrUpdateInvoice(Invoices invoice) {
    Session s = this.sessionFactory.openSession();
    Transaction tx = s.beginTransaction();
    try {
      s.saveOrUpdate(invoice);
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
