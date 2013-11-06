package cz.ispadmin.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Roman
 */
@Controller
@RequestMapping("/")
public class DefaultController {
  
  @RequestMapping("/")
  public String StartPage() {
    return "index";
  }  
  
}
