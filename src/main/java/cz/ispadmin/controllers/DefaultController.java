package cz.ispadmin.controllers;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Matul
 */
@Controller
@RequestMapping("/default")
public class DefaultController extends BaseController {

  @RequestMapping("/welcome")  
  public ModelAndView welcome() {
    this.template.setViewName("Default/welcome");
    return this.template;
  }
  
}
