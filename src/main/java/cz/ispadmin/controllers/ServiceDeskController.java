package cz.ispadmin.controllers;

import cz.ispadmin.entities.Incidents;
import cz.ispadmin.models.dao.IncidentsDAO;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Roman
 */
//@Controller
//@RequestMapping("/")
public class ServiceDeskController extends BaseController {

    private final IncidentsDAO incidentsDAO;
    private final ModelAndView modelAndView;

    @Autowired
    public ServiceDeskController(IncidentsDAO model) {
        this.incidentsDAO = model;
        this.modelAndView = new ModelAndView();
    }

    /*@RequestMapping("/")
     public ModelAndView StartPage(HttpServletRequest request, HttpServletResponse response) {
     modelAndView.setViewName("index");
     return modelAndView;
     }*/
    @RequestMapping("/users/incidents")
    public ModelAndView listIncidents() {
        List<Incidents> incidents = incidentsDAO.getAllIncidents();
        modelAndView.addObject("incidents", incidents);
        modelAndView.setViewName("incidentsList");
        return modelAndView;
    }

    @RequestMapping(value = "/user/reportBug")
    public ModelAndView reportBug(@Valid @ModelAttribute("incident") Incidents incident, BindingResult result, HttpServletRequest request) {
        if (request.getMethod().equals("POST")) {
            if (!result.hasErrors()) {
                this.incidentsDAO.insertOrUpdateIncident(incident);
                modelAndView.setViewName("redirect:/users/incidents");
                return this.modelAndView;
            }
        }
        
        this.modelAndView.addObject("action", "/ispadmin/user/reportBug/");
        this.modelAndView.setViewName("reportBug");
        return this.modelAndView;
    }
}
