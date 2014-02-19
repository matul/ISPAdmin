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
public class TestController {
  
  private final UserDAO model;
  private final ModelAndView modelAndView;

  @Autowired
  public TestController(UserDAO model) {
    this.model = model;
    this.modelAndView = new ModelAndView();
  }
  
  @RequestMapping("/users/lastTwentyClients")
  public ModelAndView lastTwentyClients() {
    List<Users> clients = model.getLastTwentyUsers();
    modelAndView.addObject("clients", clients);
    modelAndView.setViewName("lastTwentyClientsList");
    return modelAndView;
  } 
 
} 
  

