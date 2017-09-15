package com.tocsyk.controllers;

import com.tocsyk.models.Login;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String displayLoginPage( Model model){
        /*Login login = new Login();

        model.addAttribute("login");
*/
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String processLoginPage(@ModelAttribute("login")  Login login){
        System.out.println(login);
        return "redirect:welcome";
    }
}
