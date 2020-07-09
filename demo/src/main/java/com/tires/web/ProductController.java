package com.tires.web;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {
	@RequestMapping("product/add")
	public ModelAndView Add(HttpSession session) {
		SecurityContext context = SecurityContextHolder.getContext();

		ModelAndView mv = new ModelAndView();
		if (context.getAuthentication().getName() == "admin"){
			session.setAttribute("isProduct", true); 
		} else {
			session.setAttribute("isLogin", true);
			session.removeAttribute("isProduct"); 
		}
		
		mv.setViewName("home");
		return mv;
	}
}
