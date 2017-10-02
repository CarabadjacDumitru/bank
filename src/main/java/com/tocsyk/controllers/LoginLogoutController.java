package com.tocsyk.controllers;

import com.tocsyk.dao.LoginDAOImpl;
import com.tocsyk.models.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;

@Controller
public class LoginLogoutController {

    @Autowired
    public LoginDAOImpl loginDAOImpl;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView loginPage(Model model ) {
        ModelAndView mav = new ModelAndView("loginPage");
        mav.addObject("login", new Login());
        return mav;
    }

    @RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
    public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response,
                                     @ModelAttribute("login") Login login) {
        ModelAndView mav = null;
        Login login2 = loginDAOImpl.validateLogin(login);
        if (null != login2) {
            mav = new ModelAndView("welcomePage");
            mav.addObject("firstname", login2.getUserName());
        } else {
            mav = new ModelAndView("registerPage");
            mav.addObject("message", "Username or Password is wrong!!");
        }
        return mav;
    }


    @RequestMapping(value = "/logoutSuccessfull", method = RequestMethod.GET)
    public String logoutSuccessfulPage(Model model) {
        model.addAttribute("title", "Logout");
        return "logoutSuccessfullPage";
    }

    @RequestMapping(value = "/userInfo", method = RequestMethod.GET)
    public String userInfo(Model model, Principal principal) {
        String userName = principal.getName();
        System.out.println("User Name: "+ userName);
        return "userInfoPage";
    }
}
