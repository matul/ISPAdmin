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
@RequestMapping("/DeviceManagment")
public class DeviceManagmentController extends BaseController {

    private final DevicesDAO devicesDAO;
    private final String ACTION_PREFIX = "/ispadmin/DeviceManagment/";

    @Autowired
    public DeviceManagmentController(DevicesDAO devicesDAO) {
        this.devicesDAO = devicesDAO;
    }

    @RequestMapping("/list")
    public ModelAndView listDevices() {
        List<Devices> devices = this.devicesDAO.getAllDevices();
        this.template.addObject("devices", devices);
        this.template.setViewName("DeviceManagment/list");
        return this.template;
    }

    @RequestMapping(value = "/add")
    public ModelAndView addDevice(@Valid @ModelAttribute("device") Devices device, BindingResult result, HttpServletRequest request) {
        this.template.setViewName("DeviceManagment/add");

        if (request.getMethod().equals("POST")) {
            if (!result.hasErrors()) {
                this.devicesDAO.insertOrUpdateDevice(device);
                this.template.setViewName("redirect:/DeviceManagment/list");
            }
        }

        this.template.addObject("action", ACTION_PREFIX + "/add/");
        return this.template;
    }

    @RequestMapping(value = "/edit/{id}")
    public ModelAndView editDevice(@Valid @ModelAttribute("device") Devices device, BindingResult result, @PathVariable Integer id, HttpServletRequest request) {
        this.template.addObject("action", ACTION_PREFIX + "/edit/" + id);
        this.template.setViewName("DeviceManagment/add");
        
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

}
