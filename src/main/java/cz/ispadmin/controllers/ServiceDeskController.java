package cz.ispadmin.controllers;

import cz.ispadmin.entities.IncidentStates;
import cz.ispadmin.entities.Incidents;
import cz.ispadmin.models.dao.IncidentsDAO;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Roman
 */
@Controller
@RequestMapping("/serviceDesk")
public class ServiceDeskController extends BaseController {

  private final IncidentsDAO incidentsDAO;

  @Autowired
  public ServiceDeskController(IncidentsDAO model) {
    this.incidentsDAO = model;
  }

  @RequestMapping("/list")
  public ModelAndView listIncidents() {
    List<Incidents> incidents = incidentsDAO.getAllIncidents();
    this.modelAndView.addObject("incidents", incidents);
    this.modelAndView.setViewName("ServiceDesk/list");
    return this.modelAndView;
  }

  @RequestMapping(value = "/reportBug")
  public ModelAndView reportBug(@Valid @ModelAttribute("incident") Incidents incident, IncidentStates incidentS, BindingResult result, HttpServletRequest request) {
    this.modelAndView.setViewName("reportBug");
    
    if (request.getMethod().equals("POST")) {
      if (!result.hasErrors()) {
        //incident.setUser(null);
        incidentS.setState("Nahlášeno");
        incident.setState(incidentS);

        this.incidentsDAO.insertOrUpdateIncident(incident);
        this.modelAndView.setViewName("redirect:/ServiceDesk/list");
      }
    }

    this.modelAndView.addObject("action", "/ispadmin/serviceDesk/reportBug/");
    return this.modelAndView;
  }
}
