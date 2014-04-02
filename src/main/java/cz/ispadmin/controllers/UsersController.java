package cz.ispadmin.controllers;

import cz.ispadmin.services.mail.Mailer;
import cz.ispadmin.models.dao.UserDAO;
import cz.ispadmin.entities.Users;
import cz.ispadmin.services.authentication.SignedInUser;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
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
  private final String ACTION_PREFIX = "/ispadmin/users";

  @Autowired
  public UsersController(UserDAO model) {
    this.userDAO = model;
  }

  @RequestMapping("/list")
  public ModelAndView listClients() {
    List<Users> users = userDAO.getAllUsers();
    this.template.addObject("users", users);
    this.template.setViewName("Users/list");
    return template;
  }

  @RequestMapping(value = "/add")
  public ModelAndView addUser(@Valid @ModelAttribute("user") Users user, BindingResult result, HttpServletRequest request) {
    this.template.setViewName("Users/add");

    if (request.getMethod().equals("POST")) {
      if (!result.hasErrors()) {
        this.userDAO.insertOrUpdateUser(user);
        this.template.setViewName("redirect:/users/list");
      }
    }

    this.template.addObject("action", ACTION_PREFIX + "/add/");
    return this.template;
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
        this.template.setViewName("redirect:/users/list");
      }
    }

    this.template.addObject("action", ACTION_PREFIX + "/edit/" + id);
    this.template.setViewName("Users/add");
    return this.template;
  }

  @RequestMapping(value = "/editPassword/{id}")
  public ModelAndView editPassword(@PathVariable Integer id, HttpServletRequest request,
                                   Md5PasswordEncoder passEncoder) {
    HashMap<String, String> errors = new HashMap<String, String>();
    this.template.setViewName("Users/resetPassword");

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
        this.template.addObject("success", "Vaše heslo bylo úspěšně změneno.");
      }
    }
    this.template.addObject("errors", errors);
    this.template.addObject("action", "/ispadmin/users/editPassword/" + id);

    return this.template;
  }

  @RequestMapping(value = "/changePassword")
  public ModelAndView changePassword(HttpServletRequest request, Authentication auth, 
                                     Md5PasswordEncoder passEncoder) {
    
    SignedInUser signedInUser = (SignedInUser) auth.getPrincipal();

    HashMap<String, String> errors = new HashMap<String, String>();
    this.template.setViewName("Users/changePassword");
    
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
        this.template.addObject("success", "Vaše heslo bylo úspěšně změneno.");
      }
    }
    
    this.template.addObject("errors", errors);
    this.template.addObject("action", "/ispadmin/users/changePassword");

    return this.template;
  }

  @RequestMapping(value = "/sendPassword")
  public ModelAndView sendPassword(HttpServletRequest request, Mailer mailer) {

    HashMap<String, String> errors = new HashMap<String, String>();
    this.template.setViewName("Users/sendPassword");

    if (request.getMethod().equals("POST")) {
      String username = request.getParameter("username");
      Users user = this.userDAO.getUserByUsername(username);
      String email = request.getParameter("email");

      if (user == null){   
        errors.put("userNotFound", "Zadané uživatelské jméno nebylo nalezeno!");
      } else {
        String emailVarification = user.getEmail();
        if (!email.equals(emailVarification)) {
          errors.put("emailVerification", "Zadaný email neodpovídá!");
        } 
      }          
      if (errors.isEmpty()) {
        String subject = "Obnova hesla z portálu teranet.cz";
        String message = "Dobrý den,\n pro obnovu hesla na portále teranet.cz prosím použijte tento link:\n";
        mailer.sendMail(email, subject, message);
        this.template.setViewName("redirect:/authentication/login");
      }
    }
    this.template.addObject("errors", errors);
    this.template.addObject("action", "/ispadmin/users/sendPassword");

    return this.template;
  }
}
