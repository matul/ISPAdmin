package cz.ispadmin.controllers;
import cz.ispadmin.entities.Users;
import cz.ispadmin.models.*;
import java.util.List;

import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Roman
 */

@Controller
@RequestMapping("/")
public class DefaultController {
  
  private final UserDAO model;
  private final ModelAndView modelAndView;

  @Autowired
  public DefaultController(UserDAO model) {
    this.model = model;
    this.modelAndView = new ModelAndView();
  }
  
  @RequestMapping("/")
  public ModelAndView StartPage(HttpServletRequest request, HttpServletResponse response) {
    modelAndView.setViewName("index");
    return modelAndView;
  }
  
  @RequestMapping("/user/list")
  public ModelAndView listAllUsers() {
    List<Users> users = model.getAllUsers();
    modelAndView.addObject("users", users);
    modelAndView.setViewName("usersList");
    return modelAndView;
  } 
  
  @RequestMapping("/user/save")
  public ModelAndView saveUser() {
    Users user = new Users();
    user.setUsername("wooo");
    user.setFirstname("Jarda");
    user.setSurname("Klasik");
    model.insertOrUpdateUser(user);
    
    modelAndView.setViewName("index");
    return modelAndView;
  } 
  
}
