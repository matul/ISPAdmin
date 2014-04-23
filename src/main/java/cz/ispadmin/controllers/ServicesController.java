package cz.ispadmin.controllers;

import cz.ispadmin.entities.Services;
import cz.ispadmin.models.dao.ServicesDAO;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Honza
 */
@Controller
@RequestMapping("/services")
public class ServicesController extends BaseController {

  private final ServicesDAO servicesDAO;
  private final String CONTROLLER_PREFIX = "/services";

  @Autowired
  public ServicesController(ServicesDAO servicesDAO) {
    this.servicesDAO = servicesDAO;
  }

  @RequestMapping("/list")
  public ModelAndView listDevices(HttpServletRequest request) {
    this.initView("Services/list");
    this.template.addObject("editLink", this.getBaseUrl(request, CONTROLLER_PREFIX) + "/edit");
    this.template.addObject("deleteLink", this.getBaseUrl(request, CONTROLLER_PREFIX) + "/delete");
    List<Services> services = this.servicesDAO.getAllServices();
    this.template.addObject("service", services);
    return this.template;
  }

  @RequestMapping(value = "/add")
  public ModelAndView addService(@Valid @ModelAttribute("service") Services service, BindingResult result, HttpServletRequest request) {
    this.initView("Services/add");

    if (request.getMethod().equals("POST")) {
      if (!result.hasErrors()) {
        this.servicesDAO.insertOrUpdateService(service);
        this.template.setViewName("redirect:/services/list");
      }
    }

    this.template.addObject("action", this.getBaseUrl(request, CONTROLLER_PREFIX) + "/add/");
    this.template.addObject("leaveLink", this.getBaseUrl(request, CONTROLLER_PREFIX) + "/list/");
    return this.template;
  }

  @RequestMapping(value = "/edit/{id}")
  public ModelAndView editService(@Valid @ModelAttribute("device") Services service, BindingResult result, @PathVariable Integer id, HttpServletRequest request) {
    this.initView("Services/add");
    this.template.addObject("action", this.getBaseUrl(request, CONTROLLER_PREFIX) + "/edit/" + id);
    this.template.addObject("leaveLink", this.getBaseUrl(request, CONTROLLER_PREFIX) + "/list/");
   
    if (request.getMethod().equals("GET")) {
      Services d = this.servicesDAO.getServicesById(id);
      service.setData(d);
    }

    if (request.getMethod().equals("POST")) {
      if (!result.hasErrors()) {
        this.servicesDAO.insertOrUpdateService(service);
        this.template.setViewName("redirect:/services/list");
      }
    }
    return this.template;
  }

  @RequestMapping("/delete/{id}")
  public ModelAndView delete(HttpServletRequest request, @PathVariable Integer id) {
    this.initView("Services/delete");
    if (request.getMethod().equals("POST")) {
      String sent = request.getParameter("submitYes");

      if (sent != null) {
        Services service = this.servicesDAO.getServicesById(id);
        if (service != null) {
          this.servicesDAO.deleteServices(service);
        }
      }
      this.template.setViewName("redirect:/services/list");
    }
    return this.template;
  }

}
