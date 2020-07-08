package com.tires.web;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {
	@RequestMapping("product/add")
	public ModelAndView Add() {
		SecurityContext context = SecurityContextHolder.getContext();

		ModelAndView mv = new ModelAndView();
		if (context.getAuthentication().isAuthenticated()) {
			mv.setViewName("product/add");
			mv.addObject("message", "You are logged in as " + context.getAuthentication().getName());
		} else {
			mv.setViewName("login");
		}
		return mv;
	}
}
