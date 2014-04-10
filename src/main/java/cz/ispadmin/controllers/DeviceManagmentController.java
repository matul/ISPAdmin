package cz.ispadmin.controllers;

import cz.ispadmin.entities.Devices;
import cz.ispadmin.models.dao.DevicesDAO;
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
@RequestMapping("/deviceManagment")
public class DeviceManagmentController extends BaseController {

  private final DevicesDAO devicesDAO;
  private final String ACTION_PREFIX = "/deviceManagment/";

  @Autowired
  public DeviceManagmentController(DevicesDAO devicesDAO) {
    this.devicesDAO = devicesDAO;
  }

  @RequestMapping("/list")
  public ModelAndView listDevices() {
    this.initView("DeviceManagment/list");
    List<Devices> devices = this.devicesDAO.getAllDevices();
    this.template.addObject("devices", devices);
    return this.template;
  }

  @RequestMapping(value = "/add")
  public ModelAndView addDevice(@Valid @ModelAttribute("device") Devices device, BindingResult result, HttpServletRequest request) {
    this.initView("DeviceManagment/add");

    if (request.getMethod().equals("POST")) {
      if (!result.hasErrors()) {
        this.devicesDAO.insertOrUpdateDevice(device);
        this.template.setViewName("redirect:/DeviceManagment/list");
      }
    }

    this.template.addObject("action", this.getBaseUrl(request, ACTION_PREFIX) + "/add/");
    return this.template;
  }

  @RequestMapping(value = "/edit/{id}")
  public ModelAndView editDevice(@Valid @ModelAttribute("device") Devices device, BindingResult result, @PathVariable Integer id, HttpServletRequest request) {
    this.initView("DeviceManagment/add");
    this.template.addObject("action", this.getBaseUrl(request, ACTION_PREFIX) + "/edit/" + id);
   
    if (request.getMethod().equals("GET")) {
      Devices d = this.devicesDAO.getDevicesById(id);
      device.setData(d);
    }

    if (request.getMethod().equals("POST")) {
      if (!result.hasErrors()) {
        this.devicesDAO.insertOrUpdateDevice(device);
        this.template.setViewName("redirect:/DeviceManagment/list");
      }
    }
    return this.template;
  }

  @RequestMapping("/delete/{id}")
  public ModelAndView delete(HttpServletRequest request, @PathVariable Integer id) {
    this.initView("DeviceManagment/delete");
    if (request.getMethod().equals("POST")) {
      String sent = request.getParameter("submitYes");

      if (sent != null) {
        Devices device = this.devicesDAO.getDevicesById(id);
        if (device != null) {
          this.devicesDAO.deleteDevice(device);
        }
      }
      this.template.setViewName("redirect:/DeviceManagment/list");
    }
    return this.template;
  }

}
