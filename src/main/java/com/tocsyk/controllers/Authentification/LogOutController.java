package com.tocsyk.controllers.Authentification;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LogOutController {

    @RequestMapping(value = { "/logout" }, method = RequestMethod.GET)
    public String login(Model model) {

        return "logout";
    }
}
