package com.tocsyk.controllers;


import com.tocsyk.examples.Event;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("event")
public class EventController {

    @RequestMapping(value = "/event",method = RequestMethod.GET)
    public String displayValue1(Model model){
        Event event = new Event();
        event.setName("Java 1 user");
        model.addAttribute(event);
        return "redirect:event";
    }

/*
    @RequestMapping(value = "/event",method = RequestMethod.POST)
    public String displayValue2(@ModelAttribute("event") Event event){
        //Event event = new Event();
        event.setName("Java 2 user");
        event.toString();
        return "redirect:index";
    }
*/

}
