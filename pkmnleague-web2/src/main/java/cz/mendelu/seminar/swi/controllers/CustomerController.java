package cz.mendelu.seminar.swi.controllers;

import cz.mendelu.seminar.swi.dao.Customer;
import cz.mendelu.seminar.swi.domain.CustomerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author smonty
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {
    
    @ModelAttribute("customer")
    public CustomerEntity getCustomer() {
        return new CustomerEntity();
    }
    
    @Autowired
    private Customer customerFacade;
    
    @RequestMapping(value = "/allCustomers", method = RequestMethod.GET)
    public String customers(Model model) {
        model.addAttribute("customers", customerFacade.findAll());
        return "customer/allCustomers";
    }
    
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test(Model model) {
        return "customer/test";
    }
    
}
