package com.tires.web;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView Homepage() {

		SecurityContext context = SecurityContextHolder.getContext();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		mv.addObject("isLogin", "false");
		mv.addObject("message", "You are logged in as " + context.getAuthentication().getName());
		return mv;
	}
}
