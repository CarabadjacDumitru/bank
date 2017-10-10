package com.tocsyk.config;

import com.tocsyk.daoImp.MyDBAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.authentication.AuthenticationTrustResolverImpl;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.sql.DataSource;

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
    public JdbcTemplate jdbcTemplate(DataSource dataSource){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.setResultsMapCaseInsensitive(true);
        return jdbcTemplate;
    }

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

        http.authorizeRequests().antMatchers("/", "/welcome","/login","/loginregister","/registerProcess","/forgotpass","/operationSuccess","/loginforgotpass").permitAll();


        http.authorizeRequests().antMatchers("/admin*").access("hasRole('ROLE_ADMIN')");
        http.authorizeRequests().antMatchers("/bank*").access("hasAnyRole('ROLE_BANK','ROLE_ADMIN')");
        http.authorizeRequests().antMatchers("/branch*").access("hasAnyRole('ROLE_BANK','ROLE_BRANCH','ROLE_ADMIN')");
        http.authorizeRequests().antMatchers("/customer*").access("hasAnyRole('ROLE_BANK','ROLE_BRANCH','ROLE_CUSTOMER','ROLE_ADMIN')");
        http.authorizeRequests().antMatchers("/contract*").access("hasAnyRole('ROLE_BANK','ROLE_BRANCH','ROLE_CUSTOMER','ROLE_CONTRACT','ROLE_ADMIN')");
        http.authorizeRequests().antMatchers("/payment*").access("hasAnyRole('ROLE_BANK','ROLE_BRANCH','ROLE_CUSTOMER','ROLE_CONTRACT','ROLE_PAYMENT','ROLE_ADMIN')");


        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");


        http.authorizeRequests().anyRequest().authenticated()
                .and().formLogin()//
                // Submit URL of login page.
                .loginProcessingUrl("/login") // Submit URL
                .loginPage("/login")//
                .defaultSuccessUrl("/operationSuccess")//
                //.failureUrl("/login?error")//
                .usernameParameter("userName")//
                .passwordParameter("passWord")
                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/logoutSuccessful");;
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        return authenticationProvider;
    }


    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/static/**");
    }
}