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
@RequestMapping("/ispadmin")
public class DefaultController {
  
  @RequestMapping
  public String StartPage() {
    return "AHOJ";
  }  

  @RequestMapping(value = "/kotel", method = RequestMethod.GET)
  public ModelAndView handleResults(HttpServletRequest request, HttpServletResponse response) {
    ModelAndView modelAndView = new ModelAndView("index");
    return modelAndView;
  }
  
}
