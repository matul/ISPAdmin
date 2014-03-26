package cz.ispadmin.controllers;

import cz.ispadmin.models.dao.UserDAO;
import cz.ispadmin.entities.Users;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Roman
 */
@Controller
@RequestMapping("/users")
public class UsersController extends BaseController {

    private final UserDAO userDAO;
    private final String ACTION_PREFIX = "/ispadmin/users";

    @Autowired
    public UsersController(UserDAO model) {
        this.userDAO = model;
    }

    @RequestMapping("/list")
    public ModelAndView listClients() {
        List<Users> users = userDAO.getAllUsers();
        this.template.addObject("users", users);
        this.template.setViewName("Users/list");
        return template;
    }

    @RequestMapping(value = "/add")
    public ModelAndView addUser(@Valid @ModelAttribute("user") Users user, BindingResult result, HttpServletRequest request) {
        this.template.setViewName("Users/add");

        if (request.getMethod().equals("POST")) {
            if (!result.hasErrors()) {
                this.userDAO.insertOrUpdateUser(user);
                this.template.setViewName("redirect:/users/list");
            }
        }

        this.template.addObject("action", ACTION_PREFIX + "/add/");
        return this.template;
    }

    @RequestMapping(value = "/edit/{id}")
    public ModelAndView editUser(@Valid @ModelAttribute("user") Users user, BindingResult result, @PathVariable Integer id, HttpServletRequest request) {
        if (request.getMethod().equals("GET")) {
            Users u = this.userDAO.getUserById(id);
            user.setData(u);
        }

        if (request.getMethod().equals("POST")) {
            if (!result.hasErrors()) {
                this.userDAO.insertOrUpdateUser(user);
                this.template.setViewName("redirect:/users/list");
            }
        }

        this.template.addObject("action", ACTION_PREFIX + "/edit/" + id);
        this.template.setViewName("Users/add");
        return this.template;
    }

    @RequestMapping(value = "/editPassword/{id}")
    public ModelAndView editPassword(@PathVariable Integer id, HttpServletRequest request) {
        HashMap<String,String> errors = new HashMap<String,String>();
        this.template.setViewName("Users/resetPassword");
        
        if (request.getMethod().equals("POST")) {
            Users user = this.userDAO.getUserById(id);
            String password = request.getParameter("password");
            String passwordVerification = request.getParameter("passwordVerification");
            
            if (password.length() <= 6) {
                errors.put("password", "Zadané heslo není dost silné (minimálně 7 znaků).");
            }
            if (!password.equals(passwordVerification)) {
                errors.put("passwordVerification", "Zadaná hesla nesouhlasí.");
            }
            
            if (errors.isEmpty()){
                user.setPassword(password);
                this.userDAO.insertOrUpdateUser(user);
                this.template.setViewName("redirect:/users/list");
            }  
        }
        this.template.addObject("errors", errors);
        this.template.addObject("action", "/ispadmin/users/editPassword/" + id);
        
        return this.template;
    }

}
