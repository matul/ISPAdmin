package cz.ispadmin.controllers;
import cz.ispadmin.models.*;

import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Roman
 */

@Controller
@RequestMapping("/")
public class DefaultController {
  
  private ModelAndView modelAndView;
  private KotelModel kotelModel;

  public DefaultController() {
    this.modelAndView = new ModelAndView();
  }

  @Autowired
  public void setKotelModel(KotelModel kotelModel) {
    this.kotelModel = kotelModel;
  }
  
  @RequestMapping("/")
  public ModelAndView StartPage(HttpServletRequest request, HttpServletResponse response) {
    modelAndView.setViewName("index");
    return modelAndView;
  }
  
  @RequestMapping("/kotel/{ahoj}")
  public ModelAndView dejKotel(HttpServletRequest request, HttpServletResponse response) {
    modelAndView.addObject("kotelMessage", kotelModel.getKotel());
    modelAndView.setViewName("kotel");
    return modelAndView;
  } 
  
}
