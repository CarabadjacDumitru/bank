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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/")
@SessionAttributes("rolesAtr")
public class GeneralController {

    protected final Log logger = LogFactory.getLog(getClass());

    @Autowired
    public LoginDAOImpl loginDAOImpl;

    @Autowired
    AuthenticationTrustResolver authenticationTrustResolver;




    /***************************************************    LOG  IN       **********************************************************************/
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(Model model) {
        if (isCurrentAuthenticationAnonymous()) {
            model.addAttribute("title", "Login page ");
            model.addAttribute("message", "This is the start page page!");
            return "loginPage";
        } else {
            model.addAttribute("message", "Dear " + getPrincipal() + " you have been logged in ");
            model.addAttribute("title", "Operation LOGIN  Success");
            return "operationSuccess";
        }
    }

     @RequestMapping(value = "/loginSuccessfull", method = RequestMethod.GET)
    public String loginSuccessfulPage(Model model) {
        model.addAttribute("title", "Log IN");
        model.addAttribute("message", "You have been LOGGED IN");
        return "operationSuccess";
    }

    /***************************************************    REGISTER       **********************************************************************/
    @RequestMapping(value = "/registeruser", method = RequestMethod.GET)
    public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("registerPage");
        mav.addObject("loggedinuser", getPrincipal());
        mav.addObject("loginAtr", new Login());
        return mav;
    }

    @RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
    public ModelAndView doRegister(HttpServletRequest request, HttpServletResponse response,
                                   @ModelAttribute("loginAtr") Login login) {
        loginDAOImpl.registerLogin(login);
        return new ModelAndView("registerPage", "firstname", login.getUserName());
    }


    /***************************************************    LOG  OUT       **********************************************************************/
    @RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
    public String logoutSuccessfulPage(Model model) {
        model.addAttribute("title", "Log Out");
        model.addAttribute("message", "You have been LOGGED OUT");
        return "operationSuccess";
    }


    /***************************************************    LOG  Maintenance       **********************************************************************/
    @RequestMapping(value = "/forgotpass", method = RequestMethod.GET)
    public String forgotPass(Model model, Principal principal) {
        model.addAttribute("title", "Forgot Password");
        model.addAttribute("message", "You have lost your chanse");
        model.addAttribute("loggedinuser", getPrincipal());
        return "forgotpass";
    }

    @RequestMapping(value = "/userInfo", method = RequestMethod.GET)
    public String userInfo(Model model, Principal principal) {
        String userName = principal.getName();
        System.out.println("User Name: " + userName);
        model.addAttribute("loggedinuser", getPrincipal());
        return "userInfoPage";
    }

    @RequestMapping(value = {"/usermodify-{login}"}, method = RequestMethod.GET)
    public String editLogin(@PathVariable String login, ModelMap model) {
        Login login2 = loginDAOImpl.findLogin(login);
        model.addAttribute("login", login2);
        model.addAttribute("title", "User Modify Page");
        model.addAttribute("loggedinuser", getPrincipal());
        return "userModifyPage";
    }

    @RequestMapping(value = {"/usermodify-{login}"}, method = RequestMethod.POST)
    public String updateUser(BindingResult result, ModelMap model, @PathVariable Login login) {

        if (result.hasErrors()) {
            return "userModifyPage";
        }
        loginDAOImpl.updateLogin(login);
        model.addAttribute("message", "User " + login.getUserName() + " " + login.getPassword() + " was updated successfully");
        model.addAttribute("title", "Success by modifing the Login data ");
        model.addAttribute("loggedinuser", getPrincipal());

        return "operationSuccess";
    }

    @RequestMapping(value = {"/userdelete-{login}"}, method = RequestMethod.GET)
    public String deleteLogin(@PathVariable Login login,Model model) {
        model.addAttribute("title", "Success by deleting the Login data ");
        model.addAttribute("message", "Login " + login.getUserName() + " " + login.getPassword() + " was removed successfully");
        model.addAttribute("loggedinuser", getPrincipal());

        loginDAOImpl.deleteLogin(login.getUserName());
        return "operationSuccess";
    }
/*************************************************************************************************************************/



    /*@RequestMapping(value = "/logoutSuccessfull", method = RequestMethod.GET)
    public String logoutSuccessfulPage(Model model) {
        model.addAttribute("title", "Logout");
        model.addAttribute("loggedinuser", getPrincipal());
        return "logoutSuccessfullPage";
    }*/

/*
    @RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
    public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response,
                                     @ModelAttribute("loginAtr") Login login) {

        ModelAndView mav = null;
        Login login2 = loginDAOImpl.validateLogin(login);
        if (null != login2) {
            mav = new ModelAndView("operationSuccess");
            model.addAttribute("title", "Welcome here ");
            model.addAttribute("message", "This is the start page page!");
            model.addAttribute("loggedinuser", getPrincipal());
            return "loginPage";
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
        return "redirect:/login?logout";
    }
*/
    /***************************************************    ADMIN           **********************************************************************/
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage(Model model) {
        List<Login> logins = loginDAOImpl.findAllLogins();
        model.addAttribute("logins", logins);
        model.addAttribute("loggedinuser", getPrincipal());
        return "adminPage";
    }

    /***************************************************    EVERY ONE       **********************************************************************/
    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String initialPage(Model model) {
        model.addAttribute("title", "Welcome Page");
        model.addAttribute("message", "This is the start page page!");
        model.addAttribute("loggedinuser", getPrincipal());
        return "welcomePage";
    }

    @RequestMapping(value = {"/welcome"}, method = RequestMethod.GET)
    public String welcomePage(Model model) {
        model.addAttribute("title", "Welcome Page");
        model.addAttribute("message", "This is the start page page!");
        model.addAttribute("loggedinuser", getPrincipal());
        return "welcomePage";
    }


    private boolean isCurrentAuthenticationAnonymous() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authenticationTrustResolver.isAnonymous(authentication);
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

    private String getPrincipal() {
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails) principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }


}