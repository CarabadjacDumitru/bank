package com.tocsyk.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HelloController {

    @RequestMapping(value = "/hello")
    public String sayHello(ModelMap model) {
        model.addAttribute("message", "Hello Spring MVC Framework!");
        return "Hello";
    }
}

