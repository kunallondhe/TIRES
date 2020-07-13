package com.tires.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tires.web.model.Product;
import com.tires.web.model.ProductJsonResponse;
import com.tires.web.model.Search;
import com.tires.web.services.ProductServices;

@Controller
public class ProductController {
	@RequestMapping("view")
	public ModelAndView LandingPage(HttpSession session) {
		SecurityContext context = SecurityContextHolder.getContext();

		ModelAndView mv = new ModelAndView();
		if (context.getAuthentication().getName() == "admin") {

			session.setAttribute("isProduct", true);
		} else {
			session.setAttribute("isLogin", true);
			session.removeAttribute("isProduct");
		}

		mv.setViewName("home");
		return mv;
	}

	@ResponseBody
	@GetMapping(value = "product/add", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ProductJsonResponse Add(@ModelAttribute @Valid Product p, BindingResult result, HttpSession session) {
		ProductJsonResponse respone = new ProductJsonResponse();

		SecurityContext context = SecurityContextHolder.getContext();

		if (context.getAuthentication().getName().contains("admin")) {
			session.setAttribute("isProduct", true);

			if (result.hasErrors()) {

				Map<String, String> errors = result.getFieldErrors().stream()
						.collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));

				respone.setValidated(false);
				respone.setErrorMessages(errors);
			} else {
				ProductServices obj = new ProductServices();

				boolean b = obj.SaveProduct(p);
				respone.setValidated(true);
			}
		} else {
			session.setAttribute("isLogin", true);
			session.removeAttribute("isProduct");
		}

		return respone;
	}
}
