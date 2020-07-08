package com.tires.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("admin").password("1").roles("ADMIN");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
        .authorizeRequests()
           .antMatchers("/resources/**").permitAll()
           .antMatchers("/WEB-INF/locale/**").permitAll()
           .antMatchers("/shared/**").permitAll()
           .antMatchers("/","/searchbysize","/bysizeform","/home").permitAll()
           .antMatchers("/product/plp").permitAll()
           .antMatchers("/product/add").hasRole("ADMIN")
           .anyRequest().authenticated()
           .and()
       .formLogin()
           .loginPage("/login")
           .permitAll();
	}
}
