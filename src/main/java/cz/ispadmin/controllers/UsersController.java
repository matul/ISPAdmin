package cz.ispadmin.controllers;

import cz.ispadmin.models.dao.UserDAO;
import cz.ispadmin.entities.Users;
import java.util.List;

import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Roman
 */
@Controller
@RequestMapping("/users")
public class UsersController extends BaseController {

  private final UserDAO userDAO;
  private final String ACTION_PREFIX = "/ispadmin/users";

  @Autowired
  public UsersController(UserDAO model) {
    this.userDAO = model;
  }

  @RequestMapping("/list")
  public ModelAndView listClients() {
    List<Users> users = userDAO.getAllUsers();
    this.modelAndView.addObject("users", users);
    this.modelAndView.setViewName("Users/list");
    return modelAndView;
  }

  @RequestMapping(value = "/add")
  public ModelAndView addUser(@Valid @ModelAttribute("user") Users user, BindingResult result, HttpServletRequest request) {
    this.modelAndView.setViewName("Users/add");
    
    if (request.getMethod().equals("POST")) {
      if (!result.hasErrors()) {
        this.userDAO.insertOrUpdateUser(user);
        this.modelAndView.setViewName("redirect:/users/list");
      }
    }

    this.modelAndView.addObject("action", ACTION_PREFIX + "/add/");
    return this.modelAndView;
  }
  
  @RequestMapping(value = "/edit/{id}")
  public ModelAndView editUser(@Valid @ModelAttribute("user") Users user, BindingResult result, @PathVariable Integer id, HttpServletRequest request) {
    if (request.getMethod().equals("GET")) {
      Users u = this.userDAO.getUserById(id);
      user.setData(u);
    }
      
    if (request.getMethod().equals("POST")) {
      if (!result.hasErrors()) {
        this.userDAO.insertOrUpdateUser(user);
        this.modelAndView.setViewName("redirect:/users/list");
      }
    }
    
    this.modelAndView.addObject("action", ACTION_PREFIX + "/edit/" + id);
    this.modelAndView.setViewName("Users/add");
    return this.modelAndView;
  }
}
