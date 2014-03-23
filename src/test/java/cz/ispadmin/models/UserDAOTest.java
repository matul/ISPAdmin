package cz.ispadmin.models;

import cz.ispadmin.entities.Users;
import cz.ispadmin.models.dao.UserDAO;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Roman
 */
public class UserDAOTest extends ModelTest {
  private UserDAO userDao;
  
  private final Users testUser;
  private final String DEFAULT_USER_NAME = "test";
  
  public UserDAOTest() {
    this.testUser = new Users();
    this.testUser.setUsername(DEFAULT_USER_NAME);
    this.testUser.setPassword("test");
    this.testUser.setFirstname("test");
    this.testUser.setSurname("test");
    this.testUser.setDescription("test");
    this.testUser.setCity("test");
    this.testUser.setStreet("test");
    this.testUser.setPost_code("test");
    this.testUser.setEmail("sameone@something.cz");
    this.testUser.setPhone_number("+420 777 777 777");
    this.testUser.setBirthDate("12.12.1988");
  }

  @Autowired
  public void setUserDao(UserDAO userDao) {
    this.userDao = userDao;
    
    System.out.println("UserDAO.testInsertOrUpdateUser");
    boolean insertResult = this.userDao.insertOrUpdateUser(testUser);
    assertTrue("Unable to add a user.", insertResult);
  }
  
  @Test
  public void testInsertOrUpdateUser() {
    System.out.println("UserDAO.testInsertOrUpdateUser");
    boolean updateResult = this.userDao.insertOrUpdateUser(testUser);
    assertTrue("Unable to update a user.", updateResult);
  }

  @Test
  public void testGetUserById() {
    System.out.println("UserDAO.getUserById");
    Users user = this.userDao.getUserById(this.testUser.getId());
    assertNotNull("Unable to get a user by the given ID.", user);
  }

  @Test
  public void testGetUserByUsername() {
    System.out.println("UserDAO.getUserByUsername");
    Users user = this.userDao.getUserByUsername(DEFAULT_USER_NAME);
    assertNotNull("Unable to get a user by the given username.", user);
  }

  @Test
  public void testGetAllUsers() {
    System.out.println("UserDAO.getAllUsers");
    List<Users> users = this.userDao.getAllUsers();
    assertNotNull("Unable to get a user by the given username.", users);
  }

  @Test
  public void testDeleteUser() {
    System.out.println("UserDAO.deleteUser");
    boolean result = this.userDao.deleteUser(this.testUser);
    assertTrue("Unable to delete user.", result);
  }
  
}
