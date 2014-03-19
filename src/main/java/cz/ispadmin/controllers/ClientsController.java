package cz.ispadmin.controllers;

import cz.ispadmin.models.dao.UserDAO;
import cz.ispadmin.entities.Users;
import cz.ispadmin.models.*;
import java.util.List;

import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
public class ClientsController extends BaseController {

  private final UserDAO userDAO;
  private final ModelAndView modelAndView;
  private final String actionEdit = "/ispadmin/users";

  @Autowired
  public ClientsController(UserDAO model) {
    this.userDAO = model;
    this.modelAndView = new ModelAndView();
  }

  @RequestMapping("/list")
  public ModelAndView listClients() {
    List<Users> users = userDAO.getAllUsers();
    modelAndView.addObject("users", users);
    modelAndView.setViewName("clientList");
    return modelAndView;
  }

  @RequestMapping(value = "/add")
  public ModelAndView addUser(@Valid @ModelAttribute("user") Users user, BindingResult result, HttpServletRequest request) {
    if (request.getMethod().equals("POST")) {
      if (!result.hasErrors()){
        this.userDAO.insertOrUpdateUser(user);
        modelAndView.setViewName("redirect:/list");
        return this.modelAndView;
      }
    }

    this.modelAndView.addObject("action", "/ispadmin/users/add/");
    this.modelAndView.setViewName("addUser");
    return this.modelAndView;
  }
  
  @RequestMapping(value = "/edit/{id}")
  public ModelAndView editUser(@Valid @ModelAttribute("user") Users user, BindingResult result, @PathVariable Integer id, HttpServletRequest request) {
    if (request.getMethod().equals("GET")) {
      Users u = this.userDAO.getUserById(id);
      user.setData(u);
    }
      
    if (request.getMethod().equals("POST"))
      if (!result.hasErrors())
        this.userDAO.insertOrUpdateUser(user);

    this.modelAndView.addObject("action", "/ispadmin/users/edit/" + id);
    this.modelAndView.setViewName("addUser");
    return this.modelAndView;
  }
}
