package com.github.nastyakimova.onlineshop.controller;

import com.github.nastyakimova.onlineshop.entity.Customer;
import com.github.nastyakimova.onlineshop.entity.Product;
import com.github.nastyakimova.onlineshop.service.CustomerService;
import com.github.nastyakimova.onlineshop.service.ProductService;
import com.github.nastyakimova.onlineshop.service.entity.ShoppingCart;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private ShoppingCart shoppingCart;
    @Autowired
    ProductService productService;
    @Autowired
    CustomerService customerService;

    public static final Logger LOG = LoggerFactory.getLogger(ProductController.class);

    @RequestMapping(value = "get", method = RequestMethod.GET)
    public String getCart(ModelMap modelMap) {
        LOG.info("Received request to show all products in cart");
        modelMap.addAttribute("cart",shoppingCart.getProductCart());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Customer customer = customerService.getCustomerByEmail(authentication.getName());
        modelMap.addAttribute("customer",customer);
        return "cart";
    }

    @RequestMapping(value = "addProductToCart/{productID}", method = RequestMethod.GET)
    public String addProductToCart(@PathVariable Integer productID) {
        Product product = productService.getProductById(productID);
        LOG.info("Received request to add " + product + " to cart");
        shoppingCart.addProduct(product);
        return "redirect:/home";
    }

    @RequestMapping(value = "delete/{productID}", method = RequestMethod.GET)
    public String deleteProduct(@PathVariable Integer productID) {
        Product product = productService.getProductById(productID);
        LOG.info("Received request to delete " + product + " from cart");
        shoppingCart.deleteProduct(product);
        return "redirect:/cart/get";
    }

    @RequestMapping(value ="add/{productID}",method = RequestMethod.GET)
    public String addItem(@PathVariable Integer productID){
        Product product = productService.getProductById(productID);
        LOG.info("Received request to delete " + product + " from cart");
        shoppingCart.addProduct(product);
        return "redirect:/cart/get";
    }

    @RequestMapping(value = "/remove_all",method = RequestMethod.GET)
    public String removeAll(){
        LOG.info("Received request to clear cart");
        shoppingCart.emptyCart();
        return "redirect:/home";
    }


}
