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
@RequestMapping("/authentication")
public class AuthenticationController {
  
  private final ModelAndView modelAndView;
  
  public AuthenticationController() {
    this.modelAndView = new ModelAndView();
  }
  
  @RequestMapping(method = RequestMethod.GET)
  public ModelAndView loginPage(HttpServletRequest request, HttpServletResponse response) {
    modelAndView.setViewName("logIn");
    return modelAndView;
  }
  
  @RequestMapping(value = "/denied", method = RequestMethod.POST)
  public ModelAndView accessDeniedPage(HttpServletRequest request, HttpServletResponse response) {
    modelAndView.setViewName("accessDenied");
    return modelAndView;
  }
  
  @RequestMapping(value = "/login", method = RequestMethod.POST)
  public ModelAndView logIn(HttpServletRequest request, HttpServletResponse response) {
    modelAndView.setViewName("logIn");
    return modelAndView;
  }
  
}
