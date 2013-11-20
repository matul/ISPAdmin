package cz.ispadmin.models;
import cz.ispadmin.entities.Users;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @author Roman
 * test pokus konflikt
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@WebAppConfiguration
@ContextConfiguration(
  locations = {
    "file:src/main/webapp/WEB-INF/spring-servlet.xml",
    "file:src/main/webapp/WEB-INF/spring-context.xml",
    "file:src/main/webapp/WEB-INF/spring-data-source.xml",
  }
)
//@Configurableahoj
public class ModelTest {
  
  @Autowired
  private Model model;
  
  public ModelTest() {
  }
  
  @BeforeClass
  public static void setUpClass() {
  }
  
  @AfterClass
  public static void tearDownClass() {
  }
  
  @Before
  public void setUp() {
  }
  
  @After
  public void tearDown() {
  }

  /**
   * Test of getUserById method, of class Model.
   */
  @Test
  public void testGetUserById() {
    System.out.println("getUserById");
    Users user = new Users();
    user.setUsername("wooo");
    user.setFirstname("Jarda");
    user.setSurname("Klasik");
    
    Users user2 = new Users();
    user2.setUsername("wooo");
    user2.setFirstname("Jarda");
    user2.setSurname("Klasik");
    model.insertOrUpdateUser(user);
    Users dbUser = model.getUserById(1);
    System.out.println(user.toString());
    System.out.println(dbUser.toString());
    assertEquals(user.getSurname(), user2.getSurname());
  }

  /**
   * Test of getAllUsers method, of class Model.
   */
//  @Test
//  public void testGetAllUsers() {
//    System.out.println("getAllUsers");
//    Model instance = new Model();
//    List<Users> expResult = null;
//    List<Users> result = instance.getAllUsers();
//    assertEquals(expResult, result);
//    // TODO review the generated test code and remove the default call to fail.
//    fail("The test case is a prototype.");
//  }

  /**
   * Test of insertOrUpdateUser method, of class Model.
   */
//  @Test
//  public void testInsertOrUpdateUser() {
//    System.out.println("insertOrUpdateUser");
//    
//    this.user.setUsername("test");
//    this.user.setFirstname("test");
//    this.user.setSurname("test");
//    
//    boolean expResult = true;
//    boolean result = this.model.insertOrUpdateUser(this.user);
//    assertEquals(expResult, result);
//  }

  /**
   * Test of deleteUser method, of class Model.
   */
//  @Test
//  public void testDeleteUser() {
//    System.out.println("deleteUser");
//    Users user = null;
//    Model instance = new Model();
//    boolean expResult = false;
//    boolean result = instance.deleteUser(user);
//    assertEquals(expResult, result);
//    // TODO review the generated test code and remove the default call to fail.
//    fail("The test case is a prototype.");
//  }
  
}
