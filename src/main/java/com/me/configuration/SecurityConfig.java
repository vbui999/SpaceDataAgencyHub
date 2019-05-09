/*
*@author toanb
*@date 17 kwi 2019
**/
package com.me.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
//    @Override
//    protected void configure(HttpSecurity http) throws Exception
//    {
//        http
//         .csrf().disable()
//         .authorizeRequests().anyRequest().authenticated()
//         .and()
//         .httpBasic();
//    }
//  
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth)
//            throws Exception
//    {
//        auth.inMemoryAuthentication()
//            //.pa
//            .withUser("admin")
//            .password("{noop}password")
//            .roles("USER");
//    }
}