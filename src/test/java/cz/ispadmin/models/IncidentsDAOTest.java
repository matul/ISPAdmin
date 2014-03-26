package cz.ispadmin.models;

import cz.ispadmin.entities.Incidents;
import cz.ispadmin.models.dao.IncidentStatesDAO;
import cz.ispadmin.models.dao.IncidentsDAO;
import java.util.List;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author Marki
 */
public class IncidentsDAOTest extends ModelTest {
  
  private IncidentsDAO incidentDao;  
  private IncidentStatesDAO statesDao;
  private final Incidents testIncident;

  public IncidentsDAOTest() {
    this.testIncident = new Incidents();
    this.testIncident.setSubject("Technické problémy");
    this.testIncident.setMessage("Something about problem.");
  }
  
  @Autowired
  public void setIncidentsDao(IncidentsDAO incidentDao) {
    this.incidentDao = incidentDao;
    
    System.out.println("IncidentsDAO.testInsertOrUpdateIncident");
    boolean insertResult = this.incidentDao.insertOrUpdateIncident(testIncident);
    assertTrue("Unable to add a user.", insertResult);
  }
  
  @Autowired
  public void setIncidentStatesDao(IncidentStatesDAO statesDao) {
    this.statesDao = statesDao;
    this.testIncident.setState(this.statesDao.getStateById(1));
  }

  /**
   * Test of insertOrUpdateIncident method, of class IncidentsDAO.
   */
  @Test
  public void testInsertOrUpdateIncident() {
    System.out.println("IncidentsDAO.insertOrUpdateIncident");
    boolean updateResult = this.incidentDao.insertOrUpdateIncident(testIncident);
    assertTrue("Unable to update a incident.", updateResult);
  }

  /**
   * Test of getAllIncidents method, of class IncidentsDAO.
   */
  @Test
  public void testGetAllIncidents() {
    System.out.println("IncidentsDAO.getAllIncidents");

    List<Incidents> incidents = this.incidentDao.getAllIncidents();
    assertNotNull("Unable to get a incident", incidents);
  }
}
