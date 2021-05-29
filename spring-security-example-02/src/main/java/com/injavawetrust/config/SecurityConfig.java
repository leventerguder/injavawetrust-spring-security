package com.injavawetrust.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.inMemoryAuthentication()
			.withUser("user").password("{noop}password").roles("USER")
			.and()
			.withUser("admin").password("{noop}admin123").roles("USER", "ADMIN");
	}

	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/api/todos/**").hasRole("USER")
            .antMatchers("/admin/**").hasRole("ADMIN")
            .antMatchers("/ping").hasAnyRole("USER","ADMIN")
            .anyRequest().authenticated()
            .and()
            .httpBasic();
    }
    
    
    
	
}
