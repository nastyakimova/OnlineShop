package com.github.nastyakimova.onlineshop.controller;

import com.github.nastyakimova.onlineshop.entity.Authority;
import com.github.nastyakimova.onlineshop.entity.Customer;
import com.github.nastyakimova.onlineshop.entity.User;
import com.github.nastyakimova.onlineshop.service.AuthorityService;
import com.github.nastyakimova.onlineshop.service.CustomerService;
import com.github.nastyakimova.onlineshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CustomerController {
    @Autowired
    CustomerService customerService;
    @Autowired
    UserService userService;
    @Autowired
    AuthorityService authorityService;

    public static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger(ProductController.class);

    @RequestMapping(value = "/customer/new", method = RequestMethod.GET)
    public String newCustomer(ModelMap modelMap) {
        LOG.info("Received request to create a new product");
        modelMap.addAttribute("customer", new Customer());
        return "customer_form";
    }

    @RequestMapping(value = "/customer/save", method = RequestMethod.POST)
    public String addCustomer(@ModelAttribute("customer") Customer customer) {
        LOG.info("Received request to save a customer");
        customerService.saveCustomer(customer);
        User user = new User(customer.getEmail(), customer.getPassword(), true);
        userService.saveUser(user);
        Authority authority = new Authority(user, "user");
        authorityService.saveAuthority(authority);
        doAutoLogin(customer.getEmail(), customer.getPassword());
        return "redirect:/home";
    }

    private void doAutoLogin(String username, String password) {
        try {
            Authentication authentication = new UsernamePasswordAuthenticationToken(username, password);
            LOG.info("Logging in with {}" + authentication.getPrincipal());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        } catch (Exception e) {
            SecurityContextHolder.getContext().setAuthentication(null);
            LOG.error("Failure in autoLogin", e);

        }
    }

    @RequestMapping(value = "/admin/list_customers")
    public String listCustomers(ModelMap modelMap) {
        LOG.info("Received request to show all customers");
        modelMap.addAttribute("listCustomers", customerService.getAllCustomers());
        return "list_customers";
    }
}
