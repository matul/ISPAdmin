package cz.ispadmin.controllers;

import cz.ispadmin.entities.IncidentStates;
import cz.ispadmin.entities.Incidents;
import cz.ispadmin.models.dao.IncidentStatesDAO;
import cz.ispadmin.models.dao.IncidentsDAO;
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
 * @author Roman
 */
@Controller
@RequestMapping("/serviceDesk")
public class ServiceDeskController extends BaseController {

  private final IncidentsDAO incidentsDAO;
  private final IncidentStatesDAO statesDAO;
  private final String ACTION_PREFIX = "/ispadmin/serviceDesk/";

  @Autowired
  public ServiceDeskController(IncidentsDAO incidentsDAO, IncidentStatesDAO statesDAO) {
    this.incidentsDAO = incidentsDAO;
    this.statesDAO = statesDAO;
  }

  @RequestMapping("/list")
  public ModelAndView listIncidents() {
    List<Incidents> incidents = this.incidentsDAO.getAllIncidents();
    this.template.addObject("incidents", incidents);
    this.template.setViewName("ServiceDesk/list");
    return this.template;
  }

  @RequestMapping(value = "/reportBug")
  public ModelAndView reportBug(@Valid @ModelAttribute("incident") Incidents incident, IncidentStates incidentS, BindingResult result, HttpServletRequest request) {
    this.template.setViewName("ServiceDesk/reportBug");
    
    if (request.getMethod().equals("POST")) {
      if (!result.hasErrors()) {
        incident.setUser(null);
        incidentS.setState("Nahlášeno");
        incident.setState(incidentS);

        this.incidentsDAO.insertOrUpdateIncident(incident);
        this.template.setViewName("redirect:/serviceDesk/list");
      }
    }

    this.template.addObject("action", ACTION_PREFIX + "/reportBug/");
    return this.template;
  }
  
   @RequestMapping(value = "/edit/{id}")
  public ModelAndView editIncident(@Valid @ModelAttribute("incident") Incidents incident, BindingResult result, @PathVariable Integer id, HttpServletRequest request) {
    List<IncidentStates> states = this.statesDAO.getAllStates();
    this.template.addObject("states", states);
    this.template.setViewName("ServiceDesk/changeState");
    
    Incidents originalIncident = this.incidentsDAO.getIncidentById(id);
    if(incident.getState() != null) {
        int stateId = incident.getState().getId();
        incident.setData(originalIncident);
        IncidentStates newState = this.statesDAO.getStateById(stateId);
        incident.setState(newState);
    } else
        incident.setData(originalIncident);        

    if (request.getMethod().equals("POST")) {
      if (!result.hasErrors()) {
        this.incidentsDAO.insertOrUpdateIncident(incident);
        this.template.setViewName("redirect:/serviceDesk/list");
      }
    }
    
    this.template.addObject("action", ACTION_PREFIX + "/edit/" + id);
    return this.template;
  }
}
