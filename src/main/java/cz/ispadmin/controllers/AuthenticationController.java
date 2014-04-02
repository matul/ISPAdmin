package cz.ispadmin.controllers;

import cz.ispadmin.entities.Users;
import cz.ispadmin.models.dao.UserDAO;
import cz.ispadmin.services.mail.Mailer;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Roman
 */
@Controller
@RequestMapping("/authentication")
public class AuthenticationController extends BaseController {
  
  private final UserDAO userDAO;
  
  final String SECURITY_SALT = "fljsadlfkjas";
  
  @Autowired
  public AuthenticationController(UserDAO userDao) {
    this.userDAO = userDao;
  }

  @RequestMapping("/login")
  public ModelAndView logIn() {
    this.template.setViewName("Authentication/login");
    return template;
  }
  
  @RequestMapping("/logout")
  public ModelAndView logOut() {
    this.template.setViewName("Authentication/logout");
    return template;
  }
  
  @RequestMapping("/forbidden")
  public ModelAndView forbidden() {
    this.template.setViewName("Authentication/forbidden");
    return template;
  }
  
  @RequestMapping(value = "/sendForgottenPasswordLink")
  public ModelAndView sendForgottenPasswordLink(HttpServletRequest request, Mailer mailer, Md5PasswordEncoder passEncoder) {

    HashMap<String, String> errors = new HashMap<String, String>();
    this.template.setViewName("Authentication/sendForgottenPasswordLink");

    if (request.getMethod().equals("POST")) {
      String username = request.getParameter("username");
      Users user = this.userDAO.getUserByUsername(username);
      String email = request.getParameter("email");

      if (user == null){   
        errors.put("userNotFound", "Zadané uživatelské jméno nebylo nalezeno!");
      } else {
        String emailVarification = user.getEmail();
        if (!email.equals(emailVarification)) {
          errors.put("emailVerification", "Zadaný email se neshoduje s emailem pro daný účet.");
        } 
      }          
      if (errors.isEmpty()) {
        //TODO: Pořešit link
        String forgottenPasswordHash = passEncoder.encodePassword(user.getId().toString(), SECURITY_SALT);
        String subject = "Obnova hesla z portálu teranet.cz";
        String message = "Dobrý den,\n pro obnovu hesla na portále teranet.cz prosím použijte tento link: \n" +
                         "http://localhost:8080/ispadmin/authentication/recoverPassword/" + forgottenPasswordHash;
        mailer.sendMail(email, subject, message);
        user.setForgottenPassHash(forgottenPasswordHash);
        this.userDAO.insertOrUpdateUser(user);
        
        this.template.addObject("success", "Vaše heslo bylo úspěšně změněno.");
      }
    }
    this.template.addObject("errors", errors);
    this.template.addObject("action", "/ispadmin/authentication/sendForgottenPasswordLink");

    return this.template;
  }
  
  @RequestMapping(value = "/recoverPassword/{hash}")
  public ModelAndView recoverPassword(@PathVariable String hash, HttpServletRequest request, Md5PasswordEncoder passEncoder) {
    HashMap<String, String> errors = new HashMap<String, String>();
    this.template.setViewName("Authentication/recoverPassword");

    if (request.getMethod().equals("POST")) {
      Users user = this.userDAO.getUserByForgottenPassHash(hash);
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
    this.template.addObject("action", "/ispadmin/authentication/recoverPassword/" + hash);

    return this.template;
  }
  
}
