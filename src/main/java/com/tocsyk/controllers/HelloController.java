package com.tocsyk.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HelloController {

    @RequestMapping(value="/greeting")
    public String helloSend(Model m) {
        m.addAttribute("greeting", "some  sss   Value ssssss");
        return "hello";
    }
}

