package cz.ispadmin.controllers;

import cz.ispadmin.entities.Invoices;
import cz.ispadmin.models.dao.InvoicesDAO;
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
 * @author Maya
 */
@Controller
@RequestMapping("/invoices")
public class InvoicesController extends BaseController {

  private final InvoicesDAO invoicesDAO;
  private final String CONTROLLER_PREFIX = "/invoices";

  @Autowired
  public InvoicesController(InvoicesDAO invoicesDAO) {
    this.invoicesDAO = invoicesDAO;
  }

  @RequestMapping("/list")
  public ModelAndView listInvoices(HttpServletRequest request) {
    this.initView("Invoices/list");
    this.template.addObject("editLink", this.getBaseUrl(request, CONTROLLER_PREFIX) + "/edit");
    this.template.addObject("deleteLink", this.getBaseUrl(request, CONTROLLER_PREFIX) + "/delete");
    List<Invoices> invoices = this.invoicesDAO.getAllInvoices();
    this.template.addObject("invoices", invoices);
    return this.template;
  }

  @RequestMapping(value = "/add")
  public ModelAndView addInvoice(@Valid @ModelAttribute("invoice") Invoices invoice, BindingResult result, HttpServletRequest request) {
    this.initView("Invoices/add");

    if (request.getMethod().equals("POST")) {
      if (!result.hasErrors()) {
        this.invoicesDAO.insertOrUpdateInvoice(invoice);
        this.template.setViewName("redirect:/invoices/list");
      }
    }

    this.template.addObject("action", this.getBaseUrl(request, CONTROLLER_PREFIX) + "/add/");
    this.template.addObject("leaveLink", this.getBaseUrl(request, CONTROLLER_PREFIX) + "/list/");
    return this.template;
  }

  @RequestMapping(value = "/edit/{id}")
  public ModelAndView editInvoice(@Valid @ModelAttribute("invoice") Invoices invoice, BindingResult result, @PathVariable Integer id, HttpServletRequest request) {
    this.initView("Invoices/add");
    this.template.addObject("action", this.getBaseUrl(request, CONTROLLER_PREFIX) + "/edit/" + id);
    this.template.addObject("leaveLink", this.getBaseUrl(request, CONTROLLER_PREFIX) + "/list/");
   
    if (request.getMethod().equals("GET")) {
      Invoices d = this.invoicesDAO.getInvoicesById(id);
      invoice.setData(d);
    }

    if (request.getMethod().equals("POST")) {
      if (!result.hasErrors()) {
        this.invoicesDAO.insertOrUpdateInvoice(invoice);
        this.template.setViewName("redirect:/invoices/list");
      }
    }
    return this.template;
  }

  @RequestMapping("/delete/{id}")
  public ModelAndView delete(HttpServletRequest request, @PathVariable Integer id) {
    this.initView("Invoices/delete");
    if (request.getMethod().equals("POST")) {
      String sent = request.getParameter("submitYes");

      if (sent != null) {
        Invoices invoice = this.invoicesDAO.getInvoicesById(id);
        if (invoice != null) {
          this.invoicesDAO.deleteInvoice(invoice);
        }
      }
      this.template.setViewName("redirect:/invoices/list");
    }
    return this.template;
  }

}
