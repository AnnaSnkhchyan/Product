package com.luv2code.springdemo.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	BasicDataSource dataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.jdbcAuthentication().dataSource(dataSource);
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/").hasAnyRole("USER","ADMIN")
		.antMatchers("/login/**").hasAnyRole("USER","ADMIN")
		.antMatchers("/logout/**").hasAnyRole("USER","ADMIN")
		.antMatchers("/api/categories/**").hasRole("ADMIN")
		.antMatchers(HttpMethod.GET,"/api/categories/**").hasRole("USER")
		.antMatchers("/api/products/**").hasRole("ADMIN")
		.antMatchers(HttpMethod.GET,"/api/products/**").hasRole("USER")
		.antMatchers("/api/languages/**").hasRole("ADMIN")
		.antMatchers("/api/categoryTranslations/**").hasRole("ADMIN")
		.antMatchers(HttpMethod.GET,"/api/categoryTranslations/**").hasRole("USER")
		.antMatchers(HttpMethod.GET,"/api/productStatuses/**").hasAnyRole("USER","ADMIN")
		.antMatchers(HttpMethod.PUT,"/api/productStatuses/**").hasRole("ADMIN")
		.antMatchers(HttpMethod.POST,"/api/productStatuses/**").hasRole("USER")
		.antMatchers(HttpMethod.DELETE,"/api/productStatuses/**").hasRole("ADMIN")
		.antMatchers("/api/users/**").hasRole("ADMIN")
		.and()
		.formLogin().permitAll()
		.and()
		.logout()                                                                                       
		.permitAll();
	}

	
	
}
