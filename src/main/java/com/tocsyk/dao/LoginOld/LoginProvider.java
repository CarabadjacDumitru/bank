package com.tocsyk.dao.LoginOld;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.io.Serializable;


@Component("authProvider")
public class LoginProvider implements AuthenticationProvider, Serializable {


    @Autowired
    private LoginService loginService;



    @Override
    public Authentication authenticate(Authentication auth)
            throws AuthenticationException {

        String username = auth.getName();
        String password = auth.getCredentials().toString();
        System.out.println(username + " " + password);

        UserDetails user = loginService.loadUserByUsername(username);
        System.out.println(user);
        System.out.println(user.getAuthorities());

        if(user != null){
            Authentication token = new UsernamePasswordAuthenticationToken(username, password, user.getAuthorities());
            return token;
        }

        return null;
    }

    @Override
    public boolean supports(Class<? extends Object> authentication) {
        return  (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }

}
