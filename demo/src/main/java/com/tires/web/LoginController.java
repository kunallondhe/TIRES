package com.tires.web;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	@RequestMapping("/login")
	public ModelAndView Login(HttpSession session) {
		SecurityContext context = SecurityContextHolder.getContext();
		ModelAndView mv = new ModelAndView();
		if (context.getAuthentication().getName() != "admin") {
			session.removeAttribute("username");
			session.setAttribute("isLogin", true);
		}
		mv.setViewName("home");
		return mv;
	}
	
	@RequestMapping("/errorSignIn")
	public ModelAndView ErrorSignin(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		return mv;
	}
}
