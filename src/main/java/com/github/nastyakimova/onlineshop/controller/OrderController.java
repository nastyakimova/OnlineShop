package com.github.nastyakimova.onlineshop.controller;


import com.github.nastyakimova.onlineshop.entity.Customer;
import com.github.nastyakimova.onlineshop.entity.Order;
import com.github.nastyakimova.onlineshop.entity.Product;
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

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

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
        modelMap.addAttribute("orders",orderListToMap(orderService.getAllOrders()));
        return "list_orders";
    }

    @RequestMapping(value = "/order/create/{customerID}", method = RequestMethod.POST)
    public String createOrder(@PathVariable Integer customerID) {
        LOG.info("Received request to create new order");
        Customer customer = customerService.getCustomerById(customerID);
        orderService.createOrder(customer, shoppingCart.getProductCart());
        shoppingCart.emptyCart();
        return "redirect:/order/get";

    }

    @RequestMapping(value = "/order/get", method = RequestMethod.GET)
    public String getOrder(ModelMap modelMap) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Customer customer = customerService.getCustomerByEmail(authentication.getName());
        modelMap.addAttribute("orders",orderListToMap(customer.getOrderList()));
        return "customer_orders";
    }

    private Map<Order, Map<Product, Long>> orderListToMap(List<Order> orderList) {
        return orderList
                .stream()
                .collect(Collectors.toMap(
                        Function.identity(),
                        order -> order.getProductList()
                                .stream()
                                .collect(groupingBy(Function.identity(), counting()))));
    }
}
