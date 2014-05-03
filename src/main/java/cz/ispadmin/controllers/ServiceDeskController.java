package cz.ispadmin.controllers;

import cz.ispadmin.entities.IncidentStates;
import cz.ispadmin.entities.Incidents;
import cz.ispadmin.entities.Users;
import cz.ispadmin.models.dao.IncidentStatesDAO;
import cz.ispadmin.models.dao.IncidentsDAO;
import cz.ispadmin.models.dao.UsersDAO;
import cz.ispadmin.services.authentication.SignedInUser;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
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

  private final UsersDAO usersDAO;
  private final IncidentsDAO incidentsDAO;
  private final IncidentStatesDAO statesDAO;
  private final String CONTROLLER_PREFIX = "/serviceDesk";

  @Autowired
  public ServiceDeskController(UsersDAO usersDAO, IncidentsDAO incidentsDAO, IncidentStatesDAO statesDAO) {
    this.usersDAO = usersDAO;
    this.incidentsDAO = incidentsDAO;
    this.statesDAO = statesDAO;
  }

  @RequestMapping("/list")
  public ModelAndView listIncidents(HttpServletRequest request) {
    this.initView("ServiceDesk/list");
    this.template.addObject("editLink", this.getBaseUrl(request, CONTROLLER_PREFIX) + "/edit");
    List<Incidents> incidents = this.incidentsDAO.getAllIncidents();
    this.template.addObject("incidents", incidents);
    return this.template;
  }

  @RequestMapping(value = "/reportBug")
  public ModelAndView reportBug(@Valid @ModelAttribute("incident") Incidents incident, 
                                BindingResult result, Authentication auth, 
                                HttpServletRequest request) {
    this.initView("ServiceDesk/reportBug");
    this.template.addObject("leaveLink", this.getBaseUrl(request, CONTROLLER_PREFIX) + "/list/");

    if (request.getMethod().equals("POST")) {
      if (!result.hasErrors()) {
        SignedInUser currentUser = (SignedInUser)auth.getPrincipal();
        if (currentUser != null) {
          Users user = this.usersDAO.getUserById(currentUser.getUserID());
          if (user != null)
            incident.setUser(user);
        }
        
        IncidentStates state = this.statesDAO.getStateById(this.statesDAO.NEW_TICKET_STATE_ID);
        if (state != null)
          incident.setState(state);

        this.incidentsDAO.insertOrUpdateIncident(incident);
        this.template.setViewName("redirect:/serviceDesk/list");
      }
    }

    this.template.addObject("action", this.getBaseUrl(request, CONTROLLER_PREFIX) + "/reportBug");
    return this.template;
  }

  @RequestMapping(value = "/edit/{id}")
  public ModelAndView editIncident(@Valid @ModelAttribute("incident") Incidents incident, BindingResult result, @PathVariable Integer id, HttpServletRequest request) {
    this.initView("ServiceDesk/changeState");
    this.template.addObject("leaveLink", this.getBaseUrl(request, CONTROLLER_PREFIX) + "/list");
    
    List<IncidentStates> states = this.statesDAO.getAllStates();
    this.template.addObject("states", states);

    Incidents originalIncident = this.incidentsDAO.getIncidentById(id);
    if (incident.getState() != null) {
      int stateId = incident.getState().getId();
      incident.setData(originalIncident);

      IncidentStates newState = this.statesDAO.getStateById(stateId);
      originalIncident.setAnswer(incident.getAnswer());
      incident.setState(newState);
    } else {
      incident.setData(originalIncident);
    }

    if (request.getMethod().equals("POST")) {
      if (!result.hasErrors()) {
        this.incidentsDAO.insertOrUpdateIncident(incident);
        this.template.setViewName("redirect:/serviceDesk/list");
      }
    }

    this.template.addObject("action", this.getBaseUrl(request, CONTROLLER_PREFIX) + "/edit/" + id);
    return this.template;
  }
}
