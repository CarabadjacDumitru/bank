package com.tocsyk.config;

import com.tocsyk.dao.MyDBAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/*import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;*/
/*import org.springframework.security.crypto.password.PasswordEncoder;*/


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    MyDBAuthenticationService myDBAuthenticationService;


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

        // The pages does not require login
        http.authorizeRequests().antMatchers("/", "/welcome", "/login", "/logoutSuccessfull","/register").permitAll();

        http.authorizeRequests().antMatchers("/static/**").permitAll();


                // /userInfo page requires login as USER or ADMIN.
        // If no login, it will redirect to /login page.
        http.authorizeRequests().anyRequest().authenticated().antMatchers("/userInfo", "/logout","/loginSuccessfull","/loginModify")
                .access("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')");

        // For ADMIN only.
        http.authorizeRequests().antMatchers("/admin").access("hasRole('ROLE_ADMIN')");

        // When the user has logged in as XX.
        // But access a page that requires role YY,
        // AccessDeniedException will throw.
        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");

        // Config for Login Form
        http.authorizeRequests().and().formLogin()//
                // Submit URL of login page.
                .loginProcessingUrl("/j_spring_security_check") // Submit URL
                .loginPage("/login")//
                .defaultSuccessUrl("/welcome")//
                .failureUrl("/login/error")//
                .usernameParameter("j_username")//
                .passwordParameter("j_password")
                // Config for Logout Page
                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/logoutSuccessfull");

    }
}