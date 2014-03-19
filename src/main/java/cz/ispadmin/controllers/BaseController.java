package cz.ispadmin.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Base controller class
 * @author Roman
 */

@RequestMapping("/")
@Controller
public class BaseController {
  
  protected ModelAndView modelAndView;

  public BaseController() {
    this.modelAndView = new ModelAndView();
  }
  
  @RequestMapping("")
  public ModelAndView StartPage(HttpServletRequest request, HttpServletResponse response) {
    this.modelAndView.setViewName("index");
    return this.modelAndView;
  }
  
}
