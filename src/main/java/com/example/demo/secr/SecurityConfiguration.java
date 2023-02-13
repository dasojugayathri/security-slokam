package com.example.demo.secr;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true )
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

	
	@Bean
	@Override
	protected UserDetailsService userDetailsService() {
		UserDetails userdetails=User.builder()
				                .username("chary")
				                .password("{noop}chary")
				                .roles("USER","ADMIN")
				                .build();
		
		/*
		 * UserDetails user=User.builder() .username("user") .password("{noop}user")
		 * .roles("USER").build();
		 */ //we can take separately as user and admin......
		return new InMemoryUserDetailsManager(userdetails);
	}
	
	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	    	http.csrf()
	    	.disable()
		      .authorizeRequests()
		      .antMatchers(HttpMethod.GET,"/api/**").permitAll()
		      .antMatchers("/api/auth/**")
		      .permitAll()
		      .anyRequest()
		      .authenticated();
	    	
	    }
	
	
	
	
	
	
	
	
}
