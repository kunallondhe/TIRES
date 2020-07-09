package com.tires.web;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView Homepage(HttpSession session) {

		SecurityContext context = SecurityContextHolder.getContext();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		session.setAttribute("isLogin", false);
		session.setAttribute("isProduct", false);
		return mv;
	}
}
