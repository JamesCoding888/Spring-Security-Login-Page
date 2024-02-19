package j2ee.filter;

import java.util.Date;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	System.out.println(new Date() + "SecurityConfig");
        http
            .authorizeRequests()
                .antMatchers("/public/**").permitAll() // Allow access to public resources
                .anyRequest().authenticated() // Require authentication for all other requests
            .and()
            .formLogin() // Use form-based authentication
                .loginPage("/login") // Custom login page
                .permitAll() // Allow access to the login page               
            .and()
            .logout() // Enable logout
                .logoutSuccessUrl("/") // Redirect to home page after logout
                .permitAll(); // Allow access to the logout endpoint
    }
}

