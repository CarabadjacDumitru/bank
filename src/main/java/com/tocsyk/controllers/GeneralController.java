package com.tocsyk.controllers;

import com.tocsyk.model.Login;
import com.tocsyk.model.Role;
import com.tocsyk.service.ImplService.LoginServiceImpl;
import com.tocsyk.service.ImplService.RoleServiceImpl;
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
import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/")
@SessionAttributes("roleList")
public class GeneralController {

    protected final Log logger = LogFactory.getLog(getClass());

    @Autowired
    public LoginServiceImpl loginService;

    @Autowired
    public RoleServiceImpl roleService;

    @Autowired
    AuthenticationTrustResolver authenticationTrustResolver;



    //region Login
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(Model model) {
        model.addAttribute("loggedinuser", getPrincipal());
        model.addAttribute("loggedRole", roleService.getAllRoles().get(1));
        if (isCurrentAuthenticationAnonymous()) {
            model.addAttribute("title", "Login page ");
            model.addAttribute("message", "This is the start page page!");
            return "LoginPage";
        } else {
            model.addAttribute("message", "Dear " + getPrincipal() + " you have been logged in ");
            model.addAttribute("title", "Operation LOGIN  Success");
            return "operationSuccessPage";
        }
    }


    @RequestMapping(value = "/loginregister", method = RequestMethod.GET)
    public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("LoginRegisterPage");
        mav.addObject("loggedinuser", getPrincipal());
        mav.addObject("loggedRole", roleService.getAllRoles().get(1));
        mav.addObject("loginAtr", new Login());
        return mav;
    }

    @RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
    public ModelAndView doRegister(HttpServletRequest request, HttpServletResponse response,
                                   @ModelAttribute("loginAtr") Login login) {
        ModelAndView mav = null;
        mav = new ModelAndView("operationSuccessPage");
        Login log2 = new Login();
        log2.setEmail(login.getEmail());
        log2.setEnabled(login.getEnabled());
        log2.setLoginName(login.getLoginName());
        log2.setPassWord(login.getPassWord());
        log2.setRoles(login.getRoles());

        loginService.registerLogin(log2);
        mav.addObject("loggedRole", roleService.getAllRoles().get(1));
        mav.addObject("loggedinuser", getPrincipal());
        mav.addObject("firstname",login.getLoginName());
        return mav;
    }

    @RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
    public String logoutSuccessfulPage(Model model) {
        model.addAttribute("title", "Log Out");
        model.addAttribute("message", "You have been LOGGED OUT");
        model.addAttribute("loggedinuser", getPrincipal());
        model.addAttribute("loggedRole", roleService.getAllRoles().get(1));
        return "operationSuccessPage";
    }

/*
    @RequestMapping(value = "/loginforgotpass", method = RequestMethod.POST)
    public String forgotPass(Model model, Principal principal) {
        model.addAttribute("title", "Forgot Password");
        model.addAttribute("message", "You have lost your chanse");
        model.addAttribute("loggedinuser", getPrincipal());
        return "LoginForgotPassPage";
    }

    @RequestMapping(value = "/loginforgotpass", method = RequestMethod.GET)
    public String forgotPassPage(Model model) {
        return "LoginForgotPassPage";
    }
*/

    @RequestMapping(value = "/logininfo/{login}/", method = RequestMethod.GET)
    public String userInfo(Model model, Principal principal) {
        String userName = principal.getName();
        System.out.println("User Name: " + userName);
        model.addAttribute("loggedinuser", getPrincipal());
        model.addAttribute("loggedRole", roleService.getAllRoles().get(1));
        return "LoginInfoPage";
    }

    @RequestMapping(value = {"/loginmodify/{loginName}/"}, method = RequestMethod.GET)
    public String editLogin(@PathVariable String loginName, ModelMap model) {
        Login login2 = loginService.getLoginByName(loginName);
        model.addAttribute("login", login2);
        model.addAttribute("title", "User Modify Page");
        model.addAttribute("loggedinuser", getPrincipal());
        model.addAttribute("loggedRole", roleService.getAllRoles().get(1));
        return "LoginModifyPage";
    }

    @RequestMapping(value = {"/loginmodify/{loginName}/"}, method = RequestMethod.POST)
    public String updateUser(@Valid Login login, BindingResult result,
                             ModelMap model, @PathVariable String loginName) {
        loginService.updateLogin(login);
        model.addAttribute("message", "User " + loginName + " was updated successfully");
        model.addAttribute("title", "Success by modifing the Login data ");
        model.addAttribute("loggedinuser", loginName);
        model.addAttribute("loggedRole", roleService.getAllRoles().get(1));
        return "operationSuccessPage";
    }

    @RequestMapping(value = {"/logindelete/{loginName}/"}, method = RequestMethod.GET)
    public String deleteLogin(@PathVariable String loginName,Model model) {
        model.addAttribute("title", "Success by deleting the Login data ");
        model.addAttribute("message", "Login " + loginName + " was removed successfully");
        model.addAttribute("loggedinuser", getPrincipal());
        model.addAttribute("loggedRole", roleService.getAllRoles().get(1));
        loginService.deleteLogin(loginService.getLoginByName(loginName));
        return "operationSuccessPage";
    }
    //endregion Login

    //region Admin
   @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage(Model model) {
        List<Login> logins = loginService.getAllLogins();
        model.addAttribute("logins", logins);
        model.addAttribute("loggedinuser", getPrincipal());
       model.addAttribute("loggedRole", roleService.getAllRoles().get(1));
        return "adminPage";
    }
    //endregion Admin

    //region General
    @RequestMapping(value = "/operationSuccess", method = RequestMethod.GET)
    public String loginSuccessfulPage(Model model) {
        model.addAttribute("title", "Log IN");
        model.addAttribute("message", "You have been LOGGED IN");
        model.addAttribute("loggedinuser", getPrincipal());
        model.addAttribute("loggedRole", roleService.getAllRoles().get(1));
        return "operationSuccessPage";
    }

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String initialPage(Model model) {
        model.addAttribute("title", "Slash Page");
        model.addAttribute("message", "This is the slash page page!");
        model.addAttribute("loggedinuser", getPrincipal());
        model.addAttribute("loggedRole", roleService.getAllRoles().get(1));
        return "welcomePage";
    }

    @RequestMapping(value = {"/welcome"}, method = RequestMethod.GET)
    public String welcomePage(Model model) {
        model.addAttribute("title", "Welcome Page");
        model.addAttribute("message", "This is the start page page!");

        model.addAttribute("loggedinuser", getPrincipal());
        model.addAttribute("loggedRole", roleService.getAllRoles().get(1));
        return "welcomePage";
    }

    private boolean isCurrentAuthenticationAnonymous() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authenticationTrustResolver.isAnonymous(authentication);
    }

    @ModelAttribute("roleList")
    public List<Role> initializeProfiles() {
        return roleService.getAllRoles();
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
    //endregion General

    //region Bank
    @RequestMapping(value = "/bankregister", method = RequestMethod.GET)
    public String newBank(Model model) {
        model.addAttribute("loggedinuser", getPrincipal());
        return "BankRegisterPage";
    }

    @RequestMapping(value = {"/banklist"}, method = RequestMethod.GET)
    public String listBank( ModelMap model) {

        model.addAttribute("loggedinuser", getPrincipal());
        return "BankListPage";
    }

    //endregion

    //region Branch
    //endregion

    //region Customer
    //endregion

    //region Contract
    //endregion

    //region Payment
    //endregion

}