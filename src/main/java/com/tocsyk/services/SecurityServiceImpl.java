package com.tocsyk.services;


import com.tocsyk.models.Login;
import com.tocsyk.models.Role;
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
public class SecurityServiceImpl implements UserDetailsService {

    //static final Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);

    @Autowired
    private UserService userService;

    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String ssoId)
            throws UsernameNotFoundException {
        Login login = userService.findBySSO(ssoId);
        //logger.info("User : {}", user);
        if (login == null) {
            //logger.info("User not found");
            throw new UsernameNotFoundException("Username not found");
        }
        return new org.springframework.security.core.userdetails.User(login.getSsoId(), login.getPassword(),
                true, true, true, true, getGrantedAuthorities(login));
    }


    private List<GrantedAuthority> getGrantedAuthorities(Login login) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        for (Role userProfile : login.getUserProfiles()) {
            //logger.info("UserProfile : {}", userProfile);
            authorities.add(new SimpleGrantedAuthority("ROLE_" + userProfile.getType()));
        }
        //logger.info("authorities : {}", authorities);
        return authorities;
    }

}