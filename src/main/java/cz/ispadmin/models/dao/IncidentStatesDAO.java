/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.ispadmin.models.dao;

import cz.ispadmin.entities.IncidentStates;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

/**
 *
 * @author Marki
 */
@Service
public class IncidentStatesDAO extends DAO {
  
  public final int NEW_TICKET_STATE_ID = 1;

    /**
     * Returns a user by ID
     *
     * @param stateId
     * @return Incidents
     */
    public IncidentStates getStateById(int stateId) {
        Session s = this.sessionFactory.openSession();
        try {
            return (IncidentStates) s.get(IncidentStates.class, stateId);
        } catch (HibernateException e) {
            return null;
        } finally {
            s.close();
        }
    }

    public List<IncidentStates> getAllStates() {
        Session s = this.sessionFactory.openSession();
        try {
            Query query = s.createQuery("from IncidentStates");
            List<IncidentStates> incidentStates = query.list();
            return incidentStates;
        } catch (HibernateException e) {
            return null;
        } finally {
            s.close();
        }
    }
}
