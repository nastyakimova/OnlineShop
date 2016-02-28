package com.github.nastyakimova.onlineshop.controller;


import com.github.nastyakimova.onlineshop.entity.Customer;
import com.github.nastyakimova.onlineshop.entity.Order;
import com.github.nastyakimova.onlineshop.entity.Product;
import com.github.nastyakimova.onlineshop.entity.User;
import com.github.nastyakimova.onlineshop.service.CustomerService;
import com.github.nastyakimova.onlineshop.service.OrderService;
import com.github.nastyakimova.onlineshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class OrderController {
    @Autowired
    OrderService orderService;
    @Autowired
    ProductService productService;
    @Autowired
    CustomerService customerService;

    public static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger(ProductController.class);

    @RequestMapping(value = "/admin/list_orders", method = RequestMethod.GET)
    public String listOrders(ModelMap modelMap) {
        LOG.info("Received request to show all orders");
        modelMap.addAttribute("listOrders", orderService.getAllOrders());
        return "list_orders";
    }

    @RequestMapping(value = "/order/create", method = RequestMethod.POST)
    public String createOrder(@AuthenticationPrincipal User user,
                              @RequestParam("productIds") int[] productIds) {
        LOG.info("Received request to create new order");
        List<Product> products = new ArrayList<>();
        for (int id : productIds) {
            products.add(productService.getProductById(id));
        }
        Customer customer=user.getCustomer();
        orderService.createOrder(customer,new Order(),products);
        return "payment";
    }
}
