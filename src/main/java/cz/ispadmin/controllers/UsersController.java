package cz.ispadmin.controllers;

import cz.ispadmin.models.dao.UserDAO;
import cz.ispadmin.entities.Users;
import cz.ispadmin.services.authentication.SignedInUser;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.encoding.*;
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
  private final String CONTROLLER_PREFIX = "/users";

  @Autowired
  public UsersController(UserDAO model) {
    this.userDAO = model;
  }

  @RequestMapping("/list")
  public ModelAndView listClients() {
    this.initView("Users/list");
    List<Users> users = userDAO.getAllUsers();
    this.template.addObject("users", users);
    return template;
  }

  @RequestMapping(value = "/add")
  public ModelAndView addUser(@Valid @ModelAttribute("user") Users user, BindingResult result, HttpServletRequest request) {
    this.initView("Users/add");

    if (request.getMethod().equals("POST")) {
      if (!result.hasErrors()) {
        this.userDAO.insertOrUpdateUser(user);
        this.template.setViewName("redirect:/users/list");
      }
    }

    this.template.addObject("action", this.getBaseUrl(request, CONTROLLER_PREFIX) + "/add");
    return this.template;
  }

  @RequestMapping(value = "/edit/{id}")
  public ModelAndView editUser(@Valid @ModelAttribute("user") Users user, BindingResult result, @PathVariable Integer id, HttpServletRequest request) {
    this.initView("Users/add");
    
    if (request.getMethod().equals("GET")) {
      Users u = this.userDAO.getUserById(id);
      user.setData(u);
    }

    if (request.getMethod().equals("POST")) {
      if (!result.hasErrors()) {
        this.userDAO.insertOrUpdateUser(user);
        this.template.setViewName("redirect:/users/list");
      }
    }

    this.template.addObject("action", this.getBaseUrl(request, CONTROLLER_PREFIX) + "/edit/" + id);
    return this.template;
  }

  @RequestMapping(value = "/resetPassword/{id}")
  public ModelAndView resetPassword(@PathVariable Integer id, HttpServletRequest request, Md5PasswordEncoder passEncoder) {
    this.initView("Users/resetPassword");
     
    HashMap<String, String> errors = new HashMap<String, String>();
    HashMap<String, String> success = new HashMap<String, String>();
   
    if (request.getMethod().equals("POST")) {
      Users user = this.userDAO.getUserById(id);
      String password = request.getParameter("password");
      String passwordVerification = request.getParameter("passwordVerification");

      //TODO: udělat validator
      if (password.length() < 6) {
        errors.put("password", "Zadané heslo není dost silné (minimálně 6 znaků).");
      }
      if (!password.equals(passwordVerification)) {
        errors.put("passwordVerification", "Zadaná hesla nesouhlasí.");
      }

      if (errors.isEmpty()) {
        String passwordHash = passEncoder.encodePassword(password, null);
        user.setPassword(passwordHash);
        
        this.userDAO.insertOrUpdateUser(user);
        success.put("reset", "Vaše heslo bylo úspěšně změneno.");
        this.template.addObject("success", success);
      }
    }
    this.template.addObject("errors", errors);
    this.template.addObject("action", this.getBaseUrl(request, CONTROLLER_PREFIX) + "/resetPassword/" + id);

    return this.template;
  }

  @RequestMapping(value = "/changePassword")
  public ModelAndView changePassword(HttpServletRequest request, Authentication auth, Md5PasswordEncoder passEncoder) {
    this.initView("Users/changePassword");
    
    SignedInUser signedInUser = (SignedInUser) auth.getPrincipal();
    HashMap<String, String> errors = new HashMap<String, String>();
    HashMap<String, String> success = new HashMap<String, String>();
    
    if (request.getMethod().equals("POST")) {
      Users user = this.userDAO.getUserById(signedInUser.getUserID());
      
      String oldPassword = request.getParameter("oldPassword");
      String newPassword = request.getParameter("newPassword");
      String passwordVerification = request.getParameter("passwordVerification");

      String encodedOldPassword = passEncoder.encodePassword(oldPassword, null);
      if (encodedOldPassword.equals(user.getPassword())) {
        if (newPassword.length() < 6) {
          errors.put("newPassword", "Zadané heslo není dost silné (minimálně 6 znaků).");
        }
        
        if (!newPassword.equals(passwordVerification)) {
          errors.put("passwordVerification", "Ověření nového hesla nesouhlasí.");
        }
      } else {
        errors.put("oldPassword", "Původní heslo bylo zadáno chybně.");
      }

      if (errors.isEmpty()) {
        String newPasswordHash = passEncoder.encodePassword(newPassword,null);
        user.setPassword(newPasswordHash);
        this.userDAO.insertOrUpdateUser(user);
        success.put("change", "Vaše heslo bylo úspěšně změneno.");
        this.template.addObject("success", success);
      }
    }
    
    this.template.addObject("errors", errors);
    this.template.addObject("action", this.getBaseUrl(request, CONTROLLER_PREFIX) + "/changePassword");

    return this.template;
  }
}
