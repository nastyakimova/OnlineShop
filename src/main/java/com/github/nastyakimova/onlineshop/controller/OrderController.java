package com.github.nastyakimova.onlineshop.controller;


import com.github.nastyakimova.onlineshop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;

    public static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger(ProductController.class);

    @RequestMapping(value = "/list_orders", method = RequestMethod.GET)
    public String listOrders(ModelMap modelMap) {
        LOG.info("Received request to show all orders");
        modelMap.addAttribute("listOrders",orderService.getAllOrders());
        return "list_orders";
    }
}
