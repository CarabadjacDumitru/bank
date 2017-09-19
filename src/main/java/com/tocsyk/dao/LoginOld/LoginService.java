package com.tocsyk.dao.LoginOld;

import com.tocsyk.models.Login;
import com.tocsyk.models.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("loginService")
public class LoginService implements UserDetailsService {

    @Autowired
    private LoginDAOImpl loginDAOImpl;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Login login = loginDAOImpl.findLogin(username);
        System.out.println("Login = " + login);

        if (login == null) {
            throw new UsernameNotFoundException("User " + username + " was not found in the database");
        }else{
            System.out.println("-                           -                  User found in database ");
        }

        List<Role> roles = loginDAOImpl.getUserRoles();
        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();

        if (roles != null) {
            for (Role role : roles) {
                GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + role);
                System.out.println("ROLKE = " + role);
                grantList.add(authority);
            }
        }

        UserDetails userDetails = (UserDetails) new User(login.getFirstName(), login.getPassword(), grantList);
        return userDetails;
    }

}