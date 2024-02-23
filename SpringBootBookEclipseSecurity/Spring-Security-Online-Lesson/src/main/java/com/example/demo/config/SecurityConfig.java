package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/*
 * Customize Login Page, must inherit 'WebSecurityConfigurerAdapter'
 * 
 * Notice! The rule of Spring Security require to implement an instance of Hashing Algorithm
 * 
 * To implement hashing algorithms in Spring Security, you typically configure it in your security configuration class or XML configuration.  
 */
// Here's an example of how you might do it using Java configuration:
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		// Submit form-data 
		http.formLogin()
			// in *.html with action to invoke '/login'
		    .loginProcessingUrl("/login")
		    // Define a login-page in customization 
		    .loginPage("/loginpage")
		    // login successfully then access a web-page
		    .successForwardUrl("/") // e.g., '/homepage'		    
		    // login fail then access a web-page
		    .failureForwardUrl("/fail");

		// Authorization certificate
		http.authorizeHttpRequests()
			// all visitors can access
			.antMatchers("/loginpage").permitAll()
			// all visitors must be authenticated before access
			.anyRequest().authenticated();		
		
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		// For more detail of usage for 'BCryptPasswordEncoder()', please refer to SpringSecurityAuthenticationApplicationTests class
		return new BCryptPasswordEncoder();
	}
	
}
