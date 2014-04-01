package cz.ispadmin.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Roman
 */
@Controller
@RequestMapping("/authentication")
public class AuthenticationController extends BaseController {

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
  
}
