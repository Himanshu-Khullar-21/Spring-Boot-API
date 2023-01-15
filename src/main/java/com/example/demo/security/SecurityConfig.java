/**
 * This is using basic In-Memory authentication
 */


package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
  /*  @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http
                .csrf().disable()
                .authorizeRequests().anyRequest().authenticated()
                .and()
                .httpBasic();
    }*/

    @Autowired
    public void configure(AuthenticationManagerBuilder auth)
            throws Exception
    {
        auth.inMemoryAuthentication()
                .withUser("admin")
                //.password("adminpass")
                /*
                Before Spring Security 5, default PasswordEncoder was NoOpPasswordEncoder which required plain text password
                in 5, the default is Delegation Password Encoder which required password storage format
                Solution: Add password storage format for plain text, add{noop}
                Solution 2 is using UserDetailsService
                 */
                .password("{noop}adminpass")
                .authorities("ROLE_USER");
    }

}
