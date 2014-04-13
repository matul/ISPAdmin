package cz.ispadmin.models;

import cz.ispadmin.entities.Users;
import cz.ispadmin.models.dao.UsersDAO;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Roman
 */
public class UsersDAOTest extends ModelTest {
  private UsersDAO usersDao;
  
  private final Users testUser;
  private final String DEFAULT_USER_NAME = "test";
  
  public UsersDAOTest() {
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
  public void setUsersDao(UsersDAO usersDao) {
    this.usersDao = usersDao;
    
    System.out.println("UsersDAO.testInsertOrUpdateUser");
    boolean insertResult = this.usersDao.insertOrUpdateUser(testUser);
    assertTrue("Unable to add a user.", insertResult);
  }
  
  @Test
  public void testInsertOrUpdateUser() {
    System.out.println("UsersDAO.testInsertOrUpdateUser");
    boolean updateResult = this.usersDao.insertOrUpdateUser(testUser);
    assertTrue("Unable to update a user.", updateResult);
  }

  @Test
  public void testGetUserById() {
    System.out.println("UsersDAO.getUserById");
    Users user = this.usersDao.getUserById(this.testUser.getId());
    assertNotNull("Unable to get a user by the given ID.", user);
  }

  @Test
  public void testGetUserByUsername() {
    System.out.println("UsersDAO.getUserByUsername");
    Users user = this.usersDao.getUserByUsername(DEFAULT_USER_NAME);
    assertNotNull("Unable to get a user by the given username.", user);
  }

  @Test
  public void testGetAllUsers() {
    System.out.println("UsersDAO.getAllUsers");
    List<Users> users = this.usersDao.getAllUsers();
    assertNotNull("Unable to get a user by the given username.", users);
  }

  @Test
  public void testDeleteUser() {
    System.out.println("UsersDAO.deleteUser");
    boolean result = this.usersDao.deleteUser(this.testUser);
    assertTrue("Unable to delete user.", result);
  }
  
}
