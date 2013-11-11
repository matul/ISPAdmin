package cz.ispadmin.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Roman
 */
@Controller
@RequestMapping("/login")
public class LoginController {
  
  private final ModelAndView modelAndView;
  
  public LoginController() {
    this.modelAndView = new ModelAndView();
  }
  
  @RequestMapping(value = "/", method = RequestMethod.GET)
  public ModelAndView loginScreen(HttpServletRequest request, HttpServletResponse response) {
    modelAndView.setViewName("login");
    return modelAndView;
  }
  
  @RequestMapping(value = "/submit", method = RequestMethod.POST)
  public ModelAndView logIn(HttpServletRequest request, HttpServletResponse response) {
    modelAndView.setViewName("login");
    return modelAndView;
  }
  
}
