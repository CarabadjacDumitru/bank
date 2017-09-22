package com.tocsyk.controllers.Authentification;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    @RequestMapping(value = {"/hello"})
    public String welcomePage(Model model) {
        return "hello";
    }

    @RequestMapping(value = {"/nav"})
    public String navPage(Model model) {
        return "NavBar";
    }

    @RequestMapping("/")
    public String home() {
        return "welcome";
    }


}