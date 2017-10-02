package com.tocsyk.controllers;


import com.tocsyk.dao.LoginDAOImpl;
import com.tocsyk.models.Login;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@SessionAttributes("roles")
public class RegistrationController {

    protected final Log logger = LogFactory.getLog(getClass());

    @Autowired
    public LoginDAOImpl loginDAOImpl;

    @Autowired
    AuthenticationTrustResolver authenticationTrustResolver;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("registerPage");
        mav.addObject("login", new Login());
        return mav;
    }

    @RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
    public ModelAndView doRegister(HttpServletRequest request, HttpServletResponse response,
                                   @ModelAttribute("login") Login login) {
        loginDAOImpl.saveLogin(login);
        return new ModelAndView("welcomePage", "firstname", login.getUserName());
    }

    @ModelAttribute("roles")
    public List<String> initializeProfiles() {
        return loginDAOImpl.getRoles();
    }

    private boolean isCurrentAuthenticationAnonymous() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authenticationTrustResolver.isAnonymous(authentication);
    }
}