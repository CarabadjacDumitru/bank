package com.tocsyk.controllers;

import com.tocsyk.dao.LoginDAOImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminController {

    protected final Log logger = LogFactory.getLog(getClass());

    @Autowired
    public LoginDAOImpl loginDAOImpl;

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage(Model model) {
        return "adminPage";
    }
}
