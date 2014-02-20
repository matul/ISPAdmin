package cz.ispadmin.controllers;
import cz.ispadmin.entities.Users;
import cz.ispadmin.models.*;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Roman
 */

@Controller
@RequestMapping("/")
public class DefaultController {
  
  private final UserDAO userDAO;
  private final ModelAndView modelAndView;

  @Autowired
  public DefaultController(UserDAO model) {
    this.userDAO = model;
    this.modelAndView = new ModelAndView();
  }
  
  @RequestMapping("/")
  public ModelAndView StartPage(HttpServletRequest request, HttpServletResponse response) {
    modelAndView.setViewName("index");
    return modelAndView;
  }
  
  @RequestMapping("/user/listing")
  public ModelAndView listAllUsers() {
    List<Users> users = userDAO.getAllUsers();
    modelAndView.addObject("users", users);
    modelAndView.setViewName("usersList");
    return modelAndView;
  } 
  
  @RequestMapping("/users/clients")
  public ModelAndView listClients() {
    List<Users> users = userDAO.getAllUsers();
    modelAndView.addObject("users", users);
    modelAndView.setViewName("clientList");
    return modelAndView;
  } 
  
  @RequestMapping("/user/save")
  public ModelAndView saveUser() {
    Users user = new Users();
    user.setUsername("wooo");
    user.setFirstname("Jarda");
    user.setSurname("Klasik");
    userDAO.insertOrUpdateUser(user);
    
    modelAndView.setViewName("index");
    return modelAndView;
  } 
  
  @RequestMapping(value="/user/add")
   public ModelAndView addUser(@Valid Users user, BindingResult result, Model m, HttpServletRequest request) {
    if (request.getMethod().equals("POST")) {
      if(!result.hasErrors())
        this.userDAO.insertOrUpdateUser(user);
    }
    m.addAttribute("user", user);
    
    modelAndView.setViewName("addUser");
    return modelAndView;
  }
  
}
