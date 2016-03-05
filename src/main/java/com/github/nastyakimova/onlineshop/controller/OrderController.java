package com.github.nastyakimova.onlineshop.controller;


import com.github.nastyakimova.onlineshop.entity.Customer;
import com.github.nastyakimova.onlineshop.entity.Order;
import com.github.nastyakimova.onlineshop.service.CustomerService;
import com.github.nastyakimova.onlineshop.service.OrderService;
import com.github.nastyakimova.onlineshop.service.ProductService;
import com.github.nastyakimova.onlineshop.service.entity.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class OrderController {
    @Autowired
    OrderService orderService;
    @Autowired
    ProductService productService;
    @Autowired
    CustomerService customerService;
    @Autowired
    ShoppingCart shoppingCart;

    public static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger(ProductController.class);

    @RequestMapping(value = "/admin/list_orders", method = RequestMethod.GET)
    public String listOrders(ModelMap modelMap) {
        LOG.info("Received request to show all orders");
        modelMap.addAttribute("listOrders", orderService.getAllOrders());
        return "list_orders";
    }

    @RequestMapping(value = "/order/create", method = RequestMethod.POST)
    public String createOrder() {
        LOG.info("Received request to create new order");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Customer customer = customerService.getCustomerByEmail(authentication.getName());
        if (!customer.getIsLocked()) {
            orderService.createOrder(customer,shoppingCart.getProductList());
        }
        return "redirect:/home";

    }

    @RequestMapping(value = "/admin/lock_customer/{orderID}",
            method = RequestMethod.POST)
    public String lockCustomer(@PathVariable Integer orderID) {
        Order order = orderService.getOrderById(orderID);
        if (!order.getCustomer().getIsLocked()) {
            LOG.info("Received request to add order`s " + order + " owner to blacklist");
            customerService.lockCustomer(order.getCustomer());
        } else {
            LOG.info("Received request to remove order`s " + order + " owner from blacklist");
            customerService.unlockCustomer(order.getCustomer());
        }
        return "redirect:/admin/list_orders";
    }
    @RequestMapping(value = "/order/get",method = RequestMethod.GET)
    public String getOrder(ModelMap modelMap){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Customer customer = customerService.getCustomerByEmail(authentication.getName());
        modelMap.addAttribute("listOrders",customer.getOrderList());
        return "customer_orders";
    }
}
