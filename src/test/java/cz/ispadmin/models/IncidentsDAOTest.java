///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package cz.ispadmin.models;
//
//import cz.ispadmin.entities.Incidents;
//import cz.ispadmin.models.dao.IncidentsDAO;
//import java.util.List;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import static org.junit.Assert.*;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
///**
// *
// * @author Marki
// */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(
//        locations = {
//            "file:src/main/webapp/WEB-INF/spring-servlet.xml",
//            "file:src/main/webapp/WEB-INF/spring-context.xml",
//            "file:src/main/webapp/WEB-INF/spring-data-source-test.xml",}
//)
//public class IncidentsDAOTest {
//
//    @Autowired
//    private IncidentsDAO incidentDao;
//
//    private final Incidents testIncident;
//
//    public IncidentsDAOTest() {
//        this.testIncident = new Incidents();
//        this.testIncident.setSubject("Technické problémy");
//        this.testIncident.setMessage("Something about problem.");
//        //this.testIncident.setState("");
//    }
//
//    @BeforeClass
//    public void setUp() {
//        System.out.println("IncidentsDAO.testInsertOrUpdateIncident");
//        boolean insertResult = this.incidentDao.insertOrUpdateIncident(testIncident);
//        assertTrue("Unable to add a user.", insertResult);
//    }
//
//    /**
//     * Test of insertOrUpdateIncident method, of class IncidentsDAO.
//     */
//    @Test
//    public void testInsertOrUpdateIncident() {
//        System.out.println("IncidentsDAO.insertOrUpdateIncident");
//        boolean updateResult = this.incidentDao.insertOrUpdateIncident(testIncident);
//        assertTrue("Unable to update a incident.", updateResult);
//    }
//
//    /**
//     * Test of getAllIncidents method, of class IncidentsDAO.
//     */
//    @Test
//    public void testGetAllIncidents() {
//        System.out.println("IncidentsDAO.getAllIncidents");
//
//        List<Incidents> incidents = this.incidentDao.getAllIncidents();
//        assertNotNull("Unable to get a incident", incidents);
//    }
//}
