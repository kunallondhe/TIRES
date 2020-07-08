package com.tires.web;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
 import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	@RequestMapping("/login")
	public ModelAndView Login() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("isLogin","true");
		mv.setViewName("home");
		return mv;
	}

	@RequestMapping("/signin")
	public ModelAndView SignIn() {
		SecurityContext context = SecurityContextHolder.getContext();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		mv.addObject("message", "You are logged in as " + context.getAuthentication().getName());
		return mv;
	}

	@RequestMapping("/signout")
	public ModelAndView SignOut() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");
		return mv;
	}
}
