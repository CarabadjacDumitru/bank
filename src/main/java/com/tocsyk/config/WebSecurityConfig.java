package com.tocsyk.config;

import com.tocsyk.dao.LoginOld.LoginProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    LoginProvider loginProvider;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        //auth.inMemoryAuthentication().withUser("user1").password("12345").roles("USER").and().withUser("admin1").password("12345").roles("USER, ADMIN");

        auth.authenticationProvider(loginProvider);
    }

    @Override
    public void configure( WebSecurity web ) throws Exception {
        web.ignoring().antMatchers("/static/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {


        http.csrf().disable();
        http.authorizeRequests().antMatchers("/", "/userInfo", "/welcome", "/login", "/login2", "/logout","/403").permitAll();
        http.authorizeRequests().antMatchers("/userInfo").access("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')");

        //http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");

        http.authorizeRequests()
                .and()
                .formLogin()//
                .loginProcessingUrl("/j_spring_security_check")
                .loginPage("/login")//
                .defaultSuccessUrl("/userInfo")
                .failureUrl("/login?error=true")
                .usernameParameter("username")
                .passwordParameter("password")
                .and()
                .exceptionHandling().accessDeniedPage("/403");
    }

}