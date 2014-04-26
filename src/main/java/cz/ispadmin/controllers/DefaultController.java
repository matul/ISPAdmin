package cz.ispadmin.controllers;

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
    this.initView("Default/welcome");
    return this.template;
  }
  
}
