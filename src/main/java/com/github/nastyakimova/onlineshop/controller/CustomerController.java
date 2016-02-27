package com.github.nastyakimova.onlineshop.controller;

import com.github.nastyakimova.onlineshop.entity.Customer;
import com.github.nastyakimova.onlineshop.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    public static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger(ProductController.class);

    @RequestMapping(value = "customer/new", method = RequestMethod.GET)
    public String newCustomer(ModelMap modelMap) {
        LOG.info("Received request to create a new product");
        modelMap.addAttribute("customer", new Customer());
        return "customer_form";
    }

    @RequestMapping(value = "customer/save", method = RequestMethod.POST)
    public String addCustomer(@ModelAttribute("customer") Customer customer) {
        LOG.info("Received request to save a customer");
        customerService.saveCustomer(customer);
        return "redirect:/user/";
    }

    @RequestMapping(value = "admin/list_customers")
    public String listCustomers(ModelMap modelMap) {
        LOG.info("Received request to show all customers");
        modelMap.addAttribute("listCustomers", customerService.getAllCustomers());
        return "list_customers";
    }
}
