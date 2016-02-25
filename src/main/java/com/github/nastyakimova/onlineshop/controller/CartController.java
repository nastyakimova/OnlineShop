package com.github.nastyakimova.onlineshop.controller;

import com.github.nastyakimova.onlineshop.entity.Product;
import com.github.nastyakimova.onlineshop.service.entity.ShoppingCart;
import com.github.nastyakimova.onlineshop.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    public static final Logger LOG = LoggerFactory.getLogger(ProductController.class);

    @RequestMapping(value = "get", method = RequestMethod.GET)
    public String getCart(ModelMap modelMap) {
        LOG.info("Received request to show all products in cart");
        modelMap.addAttribute("cart", shoppingCart.getProductList());
        return "cart";
    }

    @RequestMapping(value = "addProductToCart/{productID}", method = RequestMethod.GET)
    public String addProductToCart(@PathVariable Integer productID) {
        Product product = productService.getProductById(productID);
        LOG.info("Received request to add " + product + " to cart");
        shoppingCart.addProduct(product);
        return "redirect:/product/";
    }

    @RequestMapping(value = "delete/{productID}", method = RequestMethod.GET)
    public String deleteProduct(@PathVariable Integer productID) {
        Product product = productService.getProductById(productID);
        LOG.info("Received request to delete " + product + " from cart");
        shoppingCart.deleteProduct(product);
        return "redirect:/cart/get";
    }


}
