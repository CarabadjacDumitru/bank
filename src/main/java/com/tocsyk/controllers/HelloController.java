package com.tocsyk.controllers;

import org.springframework.ui.Model;


//@Controller
public class HelloController {

    //@RequestMapping(value="/greeting")
    public String helloSend(Model m) {
        m.addAttribute("greeting", "some  sss   Value ssssss");
        return "hello";
    }
}

