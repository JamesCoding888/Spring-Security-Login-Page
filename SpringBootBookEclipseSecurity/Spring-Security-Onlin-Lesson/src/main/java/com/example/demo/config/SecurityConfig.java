package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/*
 * Customize Login Page, must inherit 'WebSecurityConfiguration'
 * 
 * Notice! The rule of Spring Security require to implement an instance of Hashing Algorithm
 * 
 * To implement hashing algorithms in Spring Security, you typically configure it in your security configuration class or XML configuration.  
 */
// Here's an example of how you might do it using Java configuration:
@Configuration
public class SecurityConfig extends WebSecurityConfiguration {
		
	public PasswordEncoder getPasswordEncoder() {
		// For more detail of usage for 'BCryptPasswordEncoder()', please refer to SpringSecurityAuthenticationApplicationTests class
		return new BCryptPasswordEncoder();
	}
	
}
