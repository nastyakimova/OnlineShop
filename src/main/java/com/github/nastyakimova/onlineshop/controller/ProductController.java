package com.github.nastyakimova.onlineshop.controller;

import com.github.nastyakimova.onlineshop.entity.Product;
import com.github.nastyakimova.onlineshop.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class ProductController {
    final static int pageSize = 10;

    @Autowired
    ProductService productService;

    public static final Logger LOG = LoggerFactory.getLogger(ProductController.class);

    @RequestMapping(value = {"/admin/list_products", "/admin"}, method = RequestMethod.GET)
    public String listProducts(ModelMap modelMap) {
        LOG.info("Received request to show all products");
        modelMap.addAttribute("listProducts", productService.getAllProducts());
        return "list_products";
    }

   private long countPages(long countResult) {
       return (long) Math.ceil(countResult*1.0 / pageSize*1.0);
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String showProducts(ModelMap modelMap) {
        modelMap.addAttribute("listProducts", productService.getProductPage(0, pageSize));
        modelMap.addAttribute("pageAmount", countPages(productService.getAmountPage()));
        modelMap.addAttribute("currentPage",0);
        return "home";
    }

    @RequestMapping(value = "/home/{pageNumber}", method = RequestMethod.GET)
    public String showProductsPage(@PathVariable Integer pageNumber, ModelMap modelMap) {
        modelMap.addAttribute("listProducts", productService.getProductPage(pageNumber, pageSize));
        modelMap.addAttribute("pageAmount", countPages(productService.getAmountPage()));
        modelMap.addAttribute("currentPage",pageNumber);
        return "home";
    }

    @RequestMapping(value = "/admin/product/new", method = RequestMethod.GET)
    public String newProduct(ModelMap modelMap) {
        LOG.info("Received request to create a new product");
        modelMap.addAttribute("product", new Product());
        return "product_form";
    }

    @RequestMapping(value = "/admin/product/save", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("product") Product product) {
        LOG.info("Received request to save a product");
        productService.saveProduct(product);
        return "redirect:/admin/list_products";
    }

    @RequestMapping(value = "/admin/product/edit/{productID}", method = RequestMethod.GET)
    public String editProduct(@PathVariable Integer productID, ModelMap modelMap) {
        LOG.info("Received request to edit a product");
        modelMap.addAttribute("product", productService.getProductById(productID));
        return "product_form";
    }

    @RequestMapping(value = "/admin/product/delete/{productID}", method = RequestMethod.GET)
    public String deleteProduct(@PathVariable Integer productID) {
        LOG.info("Received request to delete product");
        Product product = productService.getProductById(productID);
        productService.deleteProduct(product);
        return "redirect:/admin/list_products";
    }

}
