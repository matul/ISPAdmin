/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.ispadmin.models;

import cz.ispadmin.entities.Users;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Roman
 */
public class ModelTest {

  /**
   * Test of createUser method, of class Model.
   */
  @Test
  public void testCreateUser() {
    Model model = new Model();
    Users user = new Users("jan", "Jan", "Novák", "Ahoj");
    model.createUser(user);
    Assert.assertFalse("Chyba", true);
  }
  
}
