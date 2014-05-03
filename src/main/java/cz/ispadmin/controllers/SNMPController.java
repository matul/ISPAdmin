package cz.ispadmin.controllers;

import cz.ispadmin.services.network.SNMP;
import cz.ispadmin.services.network.Snmpwalk;
import java.util.ArrayList;
import java.util.Vector;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Matul
 */
@Controller
@RequestMapping("/snmp")
public class SNMPController extends BaseController {

  @RequestMapping("/snmp")  
  public ModelAndView welcome() {
    try {
      Snmpwalk snmpwalk = new Snmpwalk();
      snmpwalk.doSnmpwalk();
      ArrayList<String> array = snmpwalk.getResults();
      this.initView("Default/welcome");
      this.template.addObject("test", array.toString());
    }
    catch(Exception e){
      this.initView("Default/welcome");
      System.out.println("yay, chyba");
    }
    
    return this.template;
  }
  
}
