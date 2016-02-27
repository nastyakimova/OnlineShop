package com.github.nastyakimova.onlineshop.controller;


import com.github.nastyakimova.onlineshop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class OrderController {
    @Autowired
    OrderService orderService;

    public static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger(ProductController.class);

    @RequestMapping(value = "admin/list_orders", method = RequestMethod.GET)
    public String listOrders(ModelMap modelMap) {
        LOG.info("Received request to show all orders");
        modelMap.addAttribute("listOrders",orderService.getAllOrders());
        return "list_orders";
    }

   /* @RequestMapping(value = "create_order",method = RequestMethod.POST)
    public String createOrder(@ModelAttribute("orderID") int orderID,
                              @RequestParam("productIds") int[] productIds){
        LOG.info("Received request to create new order");
        List<Product> products=new ArrayList<>();
                Order order=new Order();
        for(int id:productIds) {
            products.add()
        }
    }*/
}
