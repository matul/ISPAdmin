package cz.ispadmin.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
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
  
  protected ModelAndView template;
  
  public BaseController() {
    this.template = new ModelAndView();
  }
  
  private User retrieveCurrentUser() {
    SecurityContext context = SecurityContextHolder.getContext();
    if (context != null) {
      Authentication auth = context.getAuthentication();
      if (auth != null)
        return (User)auth.getPrincipal();
    }
    
    return null;
  }
  
  @RequestMapping("")
  public ModelAndView StartPage(HttpServletRequest request, HttpServletResponse response) {
    this.template.setViewName("index");
    return this.template;
  }

  protected String getBaseUrl(HttpServletRequest request) {
    if ((request.getServerPort() == 80) || (request.getServerPort() == 443)) {
      return request.getScheme() + "://"
              + request.getServerName()
              + request.getContextPath();
    } else {
      return request.getScheme() + "://"
              + request.getServerName() + ":" + request.getServerPort()
              + request.getContextPath();
    }
  }

  protected String getBaseUrl(HttpServletRequest request, String postfix) {
    if ((request.getServerPort() == 80) || (request.getServerPort() == 443)) {
      return request.getScheme() + "://"
              + request.getServerName()
              + request.getContextPath()
              + postfix;
    } else {
      return request.getScheme() + "://"
              + request.getServerName() + ":" + request.getServerPort()
              + request.getContextPath()
              + postfix;
    }
  }

  protected void initView(String viewName) {
    this.template.setViewName(viewName);
    this.template.getModelMap().clear();
    
    User currentUser = this.retrieveCurrentUser();
    if (currentUser != null)
      this.template.addObject("currentUser", this.retrieveCurrentUser().getUsername());
  }
}
