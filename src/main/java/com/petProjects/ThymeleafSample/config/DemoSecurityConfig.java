package com.petProjects.ThymeleafSample.config;

import com.petProjects.ThymeleafSample.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//
//        // add our users for in memory authentication
//
//        UserBuilder users = User.withDefaultPasswordEncoder();
//
//        auth.inMemoryAuthentication()
//                .withUser(users.username("john").password("test123").roles("test"))
//                .withUser(users.username("mary").password("test123").roles("EMPLOYEE","MANAGER"))
//                .withUser(users.username("susan").password("test123").roles("ADMIN"));
//    }

    // add a reference to our security data source
    @Autowired
    private UserService userService;

    @Autowired
    private CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests() //restrict access based on the servlet request
                .antMatchers("/").hasRole("EMPLOYEE")  // any requesting matching it must pass by login
                .antMatchers("/leaders/**").hasRole("MANAGER")
                .antMatchers("/systems/**").hasRole("ADMIN")
                // .antMatchers("/").permitAll()  // allow public access to home page
                //.anyRequest().authenticated() // any requesting matching it must pass by login
                .and()
                .formLogin() //this means we re customizing the login process
                .loginPage("/showMyLoginPage") // show our custom login page
                .loginProcessingUrl("/authenticateTheUser") // login for will POST data to this url for processing
                .successHandler(customAuthenticationSuccessHandler)
                .permitAll()  // allow everyone to see the login page
                .and()
                .logout()
                .logoutSuccessUrl("/showMyLoginPage")  // after logout then redirect to landing page (root)
                .permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/access-denied");
        
    }

    //beans
    //bcrypt bean definition
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //authenticationProvider bean definition
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        //oussama check this
        auth.setUserDetailsService(userService); //set the custom user details service
        auth.setPasswordEncoder(passwordEncoder()); //set the password encoder - bcrypt
        return auth;
    }
}






