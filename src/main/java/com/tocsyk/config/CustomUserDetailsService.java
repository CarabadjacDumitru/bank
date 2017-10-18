package com.tocsyk.config;

import com.tocsyk.model.Login;
import com.tocsyk.model.Role;
import com.tocsyk.service.ImplService.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    LoginServiceImpl loginService;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Login login = loginService.getLoginByName(username);
        System.out.println("Login : " + login);
        if (login == null) {
            System.out.println("User not found");
            throw new UsernameNotFoundException("Username not found");
        }
        return new org.springframework.security.core.userdetails.User(login.getLoginName(), login.getPassWord(),
                true, true, true, true, getGrantedAuthorities(login));

    }

    private List<GrantedAuthority> getGrantedAuthorities(Login login) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        System.out.println("UserProfile : " + login.getRoles());

        for (Role role : login.getRoles()) {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRole()));
        }
         return authorities;
    }
}