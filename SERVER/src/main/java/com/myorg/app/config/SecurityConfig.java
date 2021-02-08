package com.myorg.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;



@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	//@Autowired Environment env;
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
         .cors().and()
         .authorizeRequests().anyRequest()
         .authenticated()
         .and()
         .httpBasic();
    }
    
    
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth)  throws Exception {
    	 auth.inMemoryAuthentication().withUser("admin").password("{noop}password").roles("USER");
    	
    	/*  NOTE: Secure Way To Supply These Values From Command Line Arguments As Given Below
    	    These options are disable so that application works out of the box. */
  
    	//  -Dspring-boot.run.arguments=--admin-user=admin, -Dspring-boot.run.arguments=--admin-password=password
    	//  String user = env.getProperty("admin-use");
    	//  String password = env.getProperty("admin-password");
    	//  auth.inMemoryAuthentication().withUser(user).password(password).roles("USER");  	
    }
}