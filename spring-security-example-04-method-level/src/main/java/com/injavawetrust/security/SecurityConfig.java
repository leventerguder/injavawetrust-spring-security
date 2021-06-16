package com.injavawetrust.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true, 
							prePostEnabled = true, 
								jsr250Enabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.inMemoryAuthentication()
		.withUser("user").password("{noop}user").roles("USER")
		.and()
		.withUser("guest").password("{noop}guest").roles("GUEST")
		.and()
		.withUser("admin").password("{noop}admin").roles("ADMIN","USER","GUEST")
		.and()
		.withUser("superAdmin").password("{noop}superAdmin").roles("SUPER_ADMIN");
		;
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().anyRequest().authenticated().and().httpBasic();
	}

}
