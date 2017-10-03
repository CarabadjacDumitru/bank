package com.tocsyk.controllers;

import com.tocsyk.dao.LoginDAOImpl;
import com.tocsyk.models.Login;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/")
@SessionAttributes("roles")
public class GeneralController {

    protected final Log logger = LogFactory.getLog(getClass());

    @Autowired
    public LoginDAOImpl loginDAOImpl;

    @Autowired
    AuthenticationTrustResolver authenticationTrustResolver;

    @RequestMapping(value = { "/" }, method = RequestMethod.GET)
    public String initialPage(Model model) {
        model.addAttribute("title", "Welcome here ");
        model.addAttribute("message", "This is intial page page!");
        model.addAttribute("loggedinuser", getPrincipal());
        return "welcomePage";
    }

    @RequestMapping(value = { "/welcome" }, method = RequestMethod.GET)
    public String welcomePage(Model model) {
        model.addAttribute("title", "Welcome page");
        model.addAttribute("message", "This is welcome page!");
        model.addAttribute("loggedinuser", getPrincipal());
        return "welcomePage";
    }


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() {
        if (isCurrentAuthenticationAnonymous()) {
            return "loginPage";
        } else {
            return "redirect:/listPage";
        }
    }

/*
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView loginPage(Model model) {
        ModelAndView mav = new ModelAndView("loginPage");
        mav.addObject("login", new Login());
        model.addAttribute("loggedinuser", getPrincipal());
        return mav;
    }*/


    @RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
    public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response,
                                     @ModelAttribute("login") Login login) {

        ModelAndView mav = null;
        Login login2 = loginDAOImpl.validateLogin(login);
        if (null != login2) {
            mav = new ModelAndView("userInfoPage");
            mav.addObject("firstname", login2.getUserName());
        } else {
            mav = new ModelAndView("registerPage");
            mav.addObject("message", "Username or Password is wrong!!");
        }
        mav.addObject("loggedinuser", getPrincipal());
        return mav;
    }


    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            SecurityContextHolder.getContext().setAuthentication(null);
        }
        return "redirect:/logoutSuccessfullPage";
    }

    @RequestMapping(value = "/logoutSuccessfull", method = RequestMethod.GET)
    public String logoutSuccessfulPage(Model model) {
        model.addAttribute("title", "Logout");
        model.addAttribute("loggedinuser", getPrincipal());
        return "logoutSuccessfullPage";
    }

    @RequestMapping(value = "/userInfo", method = RequestMethod.GET)
    public String userInfo(Model model, Principal principal) {
        String userName = principal.getName();
        System.out.println("User Name: " + userName);
        model.addAttribute("loggedinuser", getPrincipal());
        return "userInfoPage";
    }

    private boolean isCurrentAuthenticationAnonymous() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authenticationTrustResolver.isAnonymous(authentication);
    }


    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("registerPage");
        mav.addObject("loggedinuser", getPrincipal());
        mav.addObject("login", new Login());
        return mav;
    }

    @RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
    public ModelAndView doRegister(HttpServletRequest request, HttpServletResponse response,
                                   @ModelAttribute("login") Login login) {
        loginDAOImpl.registerLogin(login);
        return new ModelAndView("welcomePage", "firstname", login.getUserName());
    }

    @ModelAttribute("roles")
    public List<String> initializeProfiles() {
        return loginDAOImpl.getRoles();
    }


   @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accessDenied(Model model, Principal principal) {

        if (principal != null) {
            model.addAttribute("message", "Hi " + principal.getName()
                    + "<br> You do not have permission to access this page!");
        } else {
            model.addAttribute("msg",
                    "You do not have permission to access this page!");
        }
       model.addAttribute("loggedinuser", getPrincipal());
        return "403";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage(Model model) {
        model.addAttribute("loggedinuser", getPrincipal());
        return "adminPage";
    }

    @RequestMapping(value = { "/list" }, method = RequestMethod.GET)
    public String listUsers(ModelMap model) {
        List<Login> logins = loginDAOImpl.findAllLogins();
        model.addAttribute("logins", logins);
        model.addAttribute("loggedinuser", getPrincipal());
        return "listPage";
    }

    private String getPrincipal(){
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails)principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }
}