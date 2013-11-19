package cz.ispadmin.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Roman
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

  ModelAndView modelAndView;

  public AdminController() {
    this.modelAndView = new ModelAndView();
  }

  @RequestMapping
  public ModelAndView startPage() {
    return modelAndView;
  }

}
