/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.ispadmin.models.dao;

import cz.ispadmin.entities.Incidents;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

/**
 *
 * @author Marki
 */
@Service
public class IncidentsDAO extends DAO {

    public List<Incidents> getAllIncidents() {
        Session s = this.sessionFactory.openSession();
        try {
            Query query = s.createQuery("from Incidents");
            List<Incidents> incidents = query.list();
            return incidents;
        } catch (HibernateException e) {
            return null;
        } finally {
            s.close();
        }
    }

    public boolean insertOrUpdateIncident(Incidents incident) {
        Session s = this.sessionFactory.openSession();
        Transaction tx = s.beginTransaction();
        try {
            s.saveOrUpdate(incident);
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
