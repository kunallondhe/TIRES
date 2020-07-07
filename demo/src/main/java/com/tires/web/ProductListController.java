package com.tires.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.tires.web.model.Product;

@Controller
public class ProductListController {
	@RequestMapping("product/plp")
	public ModelAndView listpage(HttpSession session)
			throws JsonMappingException, JsonProcessingException {
		ModelAndView mv = new ModelAndView();

		List<Product> ppl2 = ((List<Product>)session.getAttribute("products"));
		mv.setViewName("product/plp");
		mv.addObject("products", ppl2);
		
		session.removeAttribute("products");
		return mv;
	}
}
