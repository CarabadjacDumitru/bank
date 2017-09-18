package com.tocsyk.controllers;

import com.tocsyk.models.Login;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

    // GET: Show Login Page
    @RequestMapping(value = { "/login" }, method = RequestMethod.GET)
    public String login(Model model) {

        return "login";
    }

    @RequestMapping(value = { "/accountInfo" }, method = RequestMethod.GET)
    public String accountInfo(Model model) {

        Login login = (Login) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(login.getPassword());
        System.out.println(login.getUserName());

        model.addAttribute("Login", login);
        return "accountInfo";
    }
}
