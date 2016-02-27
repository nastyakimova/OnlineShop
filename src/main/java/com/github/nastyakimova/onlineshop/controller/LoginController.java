package com.github.nastyakimova.onlineshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class LoginController {
    @RequestMapping(value = "login")
    public String getLoginForm() {
        return "login";
    }
}
