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
		auth.inMemoryAuthentication().withUser("admin").password("{noop}1").roles("ADMIN");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/resources/**").permitAll().antMatchers("/WEB-INF/locale/**").permitAll()
				.antMatchers("/shared/**").permitAll()
				.antMatchers("/", "/searchbysize", "/bysizeform", "/home").permitAll()
				.antMatchers("/product/plp").permitAll().antMatchers("/product/add").hasRole("ADMIN").anyRequest()
				.authenticated().and()
				.formLogin()
				.loginPage("/login")
				.loginProcessingUrl("/signin")
				.usernameParameter("userid")
				.passwordParameter("passwd")
				.successHandler((req, res, auth) -> {
					req.getSession().setAttribute("isLogin", true);
					req.getSession().setAttribute("username", auth.getName());
					res.sendRedirect("home");
				}).failureHandler((req, res, exp) -> {
					String errMsg = "";
					if (exp.getClass().isAssignableFrom(BadCredentialsException.class)) {
						errMsg = "Invalid username or password.";
					} else {
						errMsg = "Unknown error - " + exp.getMessage();
					}
					req.getSession().setAttribute("message", errMsg);
					req.getSession().removeAttribute("username");
					req.getSession().setAttribute("isLogin", true);
					res.sendRedirect("errorSignIn");
				}).permitAll().and().logout().logoutUrl("/signout").logoutSuccessHandler((req, res, auth) -> {
					req.getSession().removeAttribute("username");
					req.getSession().setAttribute("isLogin", true);
					req.getSession().setAttribute("message", "You are logged out successfully.");
					res.sendRedirect("errorSignIn");
				}).permitAll().and().csrf().disable();
	}
}
