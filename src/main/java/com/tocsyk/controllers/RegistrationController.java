package com.tocsyk.controllers;

import com.tocsyk.models.Login;
import com.tocsyk.models.Role;
import com.tocsyk.services.RoleService;
import com.tocsyk.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;
import java.util.Locale;


@Controller
@RequestMapping("/")
@SessionAttributes("roles")
public class RegistrationController {
    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @Autowired
    MessageSource messageSource;

    @Autowired
    PersistentTokenBasedRememberMeServices persistentTokenBasedRememberMeServices;

    @Autowired
    AuthenticationTrustResolver authenticationTrustResolver;


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("login");
        mav.addObject("loginPage", new Login());
        return mav;
    }



    @RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
    public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response,
                                     @ModelAttribute("login") Login login) {
        ModelAndView mav = null;
        Login login1 = userService.findBySSO(login.getSsoId());
        if (null != login) {
            mav = new ModelAndView("userInfoPage");
            mav.addObject("firstname", login.getFirstName());
        } else {
            mav = new ModelAndView("loginPage");
            mav.addObject("message", "Username or Password is wrong!!");
        }
        return mav;
    }






    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            persistentTokenBasedRememberMeServices.logout(request, response, auth);
            SecurityContextHolder.getContext().setAuthentication(null);
        }
        return "redirect:/logoutSuccessfullPage";
    }

    @RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
    public String logoutSuccessfulPage(Model model) {
        model.addAttribute("title", "Logout");
        return "logoutSuccessfullPage";
    }




    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public ModelAndView welcomePage() {
        ModelAndView model = new ModelAndView();
        model.addObject("title", "Spring Security Hello World");
        model.addObject("message", "This is welcome page!");
        model.setViewName("welcomePage");
        return model;
    }

    @RequestMapping(value = {"/register"}, method = RequestMethod.GET)
    public String newUser(ModelMap model) {
        Login login = new Login();
        model.addAttribute("user", login);
        model.addAttribute("edit", false);
        model.addAttribute("loggedinuser", getPrincipal());
        return "registerPage";
    }


    @RequestMapping(value = {"/register"}, method = RequestMethod.POST)
    public String saveUser(@Valid Login login, BindingResult result,
                           ModelMap model) {
        if (result.hasErrors()) {
            return "registerPage";
        }
        if (!userService.isUserSSOUnique(login.getId(), login.getSsoId())) {
            FieldError ssoError = new FieldError("user", "ssoId",
                    messageSource.getMessage("non.unique.ssoId", new String[]{login.getSsoId()}, Locale.getDefault()));
            result.addError(ssoError);
            return "registerPage";
        }
        userService.saveLogin(login);
        model.addAttribute("success", "User " + login.getFirstName() + " " + login.getLastName() + " registered successfully");
        model.addAttribute("loggedinuser", getPrincipal());
        //return "success";
        return "userInfoPage";
    }




    @RequestMapping(value = {"/loginmodify"}, method = RequestMethod.GET)
    public String editUser(ModelMap model) {
        //Login login = userService.findBySSO(ssoId);
        model.addAttribute("user", "2");
        model.addAttribute("edit", true);
        model.addAttribute("loggedinuser", getPrincipal());
        return "LoginModifyPage";
    }

    @RequestMapping(value = {"/loginmodify"}, method = RequestMethod.POST)
    public String updateUser(@Valid Login login, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "LoginModify";
        }
        userService.updateLogin(login);
        model.addAttribute("success", "User " + login.getFirstName() + " " + login.getLastName() + " updated successfully");
        model.addAttribute("loggedinuser", getPrincipal());
        return "LoginModifyPage";
    }


    @RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
    public String accessDeniedPage(ModelMap model) {
        model.addAttribute("loggedinuser", getPrincipal());
        return "403";
    }



/*
    @RequestMapping(value = {"/delete-user-{ssoId}"}, method = RequestMethod.GET)
    public String deleteUser(@PathVariable String ssoId) {
        userService.deleteUserBySSO(ssoId);
        return "redirect:/list";
    }


    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage(Model model) {
        return "admin";
    }

    @RequestMapping(value = {"/list"}, method = RequestMethod.GET)
    public String listLogins(ModelMap model) {
        List<Login> login = userService.findAllLogins();
        model.addAttribute("users", login);
        model.addAttribute("loggedinuser", getPrincipal());
        return "loginlist";
    }

*/

    @ModelAttribute("roles")
    public List<Role> initializeProfiles() {
        return roleService.findAll();
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

    private boolean isCurrentAuthenticationAnonymous() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authenticationTrustResolver.isAnonymous(authentication);
    }

}