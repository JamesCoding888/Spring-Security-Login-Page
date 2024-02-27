package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.example.demo.handle.MyAccessDeniedHandler;

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
	
	@Autowired
	private MyAccessDeniedHandler myAccessDeniedHandler;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		// Submit form-data 
		http.formLogin()
			/*
			 * The '.loginProcessingUrl("/login")' method is used to specify the URL where the login form should be submitted. 
			 * It tells Spring Security where to send the POST request containing the user's credentials for authentication.
			 * 
			 * However, if you only specify '.loginPage("/loginpage")' without also configuring '.loginProcessingUrl("/login")', 
			 * Spring Security won't know where to process the login form submission.
			 * 
			 * When you configure .loginPage("/loginpage"), you're telling Spring Security that requests to '/loginpage' 
			 * should be treated as the login page for your application. 
			 * 
			 * This means that when a user attempts to access a secured resource without being authenticated, 
			 * Spring Security will redirect them to the '/loginpage' URL.
			 * 
			 * So, both .loginPage("/loginpage") and .loginProcessingUrl("/login") are necessary to properly configure Spring Security for form-based authentication. 
			 * 
			 * The former specifies the URL of the login page, and the latter specifies the URL where the login form should be submitted for processing.
			 */
		    .loginProcessingUrl("/login")
		    // Define a login-page in customization; otherwise, will redirect to the default login-page
		    .loginPage("/loginpage")
		    // login successfully then access a web-page
		    .successForwardUrl("/") // e.g., '/homepage'		    
		    // login fail then access a web-page
		    .failureForwardUrl("/fail");

		// Authorization certificate
		/*
		 * This configuration is using authorizeRequests() method to define authorization rules. Here's what each line does:
		 * 
		 * .antMatchers("/loginpage").permitAll(): 
		 * 		
		 * 		This line specifies that requests to the "/loginpage" URL should be permitted for all users (permitAll()), meaning they can access this page without being authenticated.
		 * 
		 * .anyRequest().authenticated(): 
		 * 
		 * 		This line specifies that any request that doesn't match the previous rule (i.e., requests to URLs other than "/loginpage") must be authenticated. 
		 * 		In other words, any other request besides "/loginpage" requires the user to be authenticated.
		 */
		http.authorizeHttpRequests()
			// all visitors can access without authorization
			.antMatchers("/loginpage").permitAll()
			// Authorities Verification
			// Only admin allows to access
			.antMatchers("/adminpage").hasAuthority("admin")
			// Only manager allows to access
			.antMatchers("/managerpage").hasRole("manager")
			// All users allows to access
			.antMatchers("/employeepage").hasAnyRole("manager", "employee")
			// All visitors must be authenticated before access
			.anyRequest().authenticated();		
		
		// http.csrf().disable(); // Turn off CSRF protection (Not suggestion!)
		
		// Logout implementation - 1.
		/*
		 * With CSRF protection enabled, Spring Security automatically adds a CSRF token to forms submitted in your application. 
		 * When submitting the logout request, your frontend (e.g., a web page) should include this CSRF token as part of the form data. 
		 * Typically, this is done automatically if you're using Spring Security's form-based login mechanism, as Spring Security's Thymeleaf support, 
		 * for example, automatically includes the CSRF token in forms. 
		 * 
		 * CSRF protection typically involves generating a token on the server and ensuring that this token is submitted with each request that modifies server-side state (including logout requests).
		 */
		http.logout()
			.deleteCookies("JESSIONID")
			.logoutSuccessUrl("/loginpage");

		// Logout implementation - 2. (Not suggestion!)
		http.logout()
			.deleteCookies("JESSIONID")
			.logoutSuccessUrl("/loginpage")
			// Creates a matcher with the specific pattern (e.g., '/logout') which will match all HTTP methods in a case sensitive manner.
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
		
		
		// Exception Handler
		/*
		 * If you want to use a custom access denied handler (myAccessDeniedHandler), 
		 * you should remove or comment out the accessDeniedPage configuration. 
		 * 
		 * Alternatively, if you want to redirect to a specific page when access is denied, 
		 * you should remove or comment out the accessDeniedHandler configuration.
		 */
		http.exceptionHandling()
			//.accessDeniedPage("/exception");  // customized page, e.g., '/exception.html'
			.accessDeniedHandler(myAccessDeniedHandler);
		
		
		//	Remember-me
		/*
		 * If the session validity is set to 30 minutes, it means that a user's session will remain active for 30 minutes after their last interaction with the application. 
		 * During this time, the user can continue to access the application without needing to log in again.
		 * 
		 * In conjunction with remember-me functionality, the remember-me token validity period should typically be longer than the session validity period. 
		 * This is because remember-me allows users to remain authenticated even after their session expires, as long as the remember-me token is still valid.
		 * 
		 * For example, if your session validity is set to 30 minutes, you might set the remember-me token validity period to something longer, 
		 * like several hours or even days, depending on your application's requirements. 
		 * This ensures that users who choose the "remember me" option can remain authenticated across sessions for an extended period of time without needing to log in again. 
		 * However, it's important to balance the convenience of longer remember-me token validity periods with security considerations.
		 */
		http.rememberMe()
			.userDetailsService(userDetailsService)
			.tokenValiditySeconds(60); // e.g., 30 mins -> 60 * 30 
		
	}
	
	/*
	 * Notice here! This method 'getPasswordEncoder()' is indeed part of the regulation of Spring Security requiring an instance of a hashing algorithm for secure password handling.
	 * By defining a method like getPasswordEncoder() annotated with @Bean, you're instructing Spring to create and manage a PasswordEncoder bean. 
	 * In the provided code snippet, it's configured to return an instance of BCryptPasswordEncoder, which is a widely used and recommended hashing algorithm for password security.
	 * 
	 * For more detail of usage for 'BCryptPasswordEncoder()', please refer to SpringSecurityAuthenticationApplicationTests class.
	 */
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}	
}
