package com.github.nastyakimova.onlineshop.controller;

import com.github.nastyakimova.onlineshop.entity.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
@SessionAttributes({"cart"})
public class CartController {
    @RequestMapping(method = RequestMethod.GET)
    public String getCart(ModelMap modelMap) {
        if(!modelMap.containsAttribute("cart")) {
            modelMap.addAttribute("cart", new ArrayList<Product>());
        }
        return "home";
    }
    @RequestMapping(value = "addProductToCart", method = RequestMethod.POST)
     public String addProductToCart(@ModelAttribute("product") Product product,
                              @ModelAttribute("cart") List<Product> cart) {
        cart.add(product);
        return "redirect:/";
    }

    @RequestMapping(value = "/payment",method = RequestMethod.POST)


}
