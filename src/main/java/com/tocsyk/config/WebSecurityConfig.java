package com.tocsyk.config;

import com.tocsyk.dao.MyDBAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.authentication.AuthenticationTrustResolverImpl;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/*import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;*/
/*import org.springframework.security.crypto.password.PasswordEncoder;*/


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    @Qualifier("customUserDetailsService")
    UserDetailsService userDetailsService;


    @Autowired
    MyDBAuthenticationService myDBAuthenticationService;


    @Bean
    public AuthenticationTrustResolver getAuthenticationTrustResolver() {
        return new AuthenticationTrustResolverImpl();
    }

    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        // Users in memory.

     /*   auth.inMemoryAuthentication().withUser("user1").password("12345").roles("USER");
        auth.inMemoryAuthentication().withUser("admin1").password("12345").roles("USER, ADMIN");
*/
        // For User in database.
        auth.userDetailsService(myDBAuthenticationService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable();

        http.authorizeRequests().antMatchers("/", "/login","/register", "/loginProcess").anonymous();

        http.authorizeRequests().antMatchers("/userInfo","/welcome").access("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')");

        http.authorizeRequests().antMatchers("/admin").access("hasRole('ROLE_ADMIN')");


        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");


        http.authorizeRequests().and().formLogin()//
                // Submit URL of login page.
                //.loginProcessingUrl("/j_spring_security_check") // Submit URL
                .loginPage("/login")//
                .defaultSuccessUrl("/welcome")//
                //.failureUrl("/login?error")//
                .usernameParameter("username")//
                .passwordParameter("password");

    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/static/**");
    }
}