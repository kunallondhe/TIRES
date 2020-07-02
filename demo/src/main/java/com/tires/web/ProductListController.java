package com.tires.web;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tires.web.model.Product;

@Controller
public class ProductListController {
	/*
	 * @RequestMapping("/plp") public ModelAndView listpage(@RequestParam String
	 * tempproducts) throws JsonMappingException, JsonProcessingException {
	 * ModelAndView mv = new ModelAndView();
	 * 
	 * ObjectMapper mapper = new ObjectMapper(); List<Product> ppl2 =
	 * Arrays.asList(mapper.readValue(tempproducts, Product[].class));
	 * mv.setViewName("plp"); mv.addObject("products", ppl2); return mv; }
	 */
	
	@RequestMapping("product/plp")
	public ModelAndView listpage(HttpSession session)
			throws JsonMappingException, JsonProcessingException {
		ModelAndView mv = new ModelAndView();

		List<Product> ppl2 = (List<Product>)session.getAttribute("products");
		mv.setViewName("product/plp");
		mv.addObject("products", ppl2);
		return mv;
	}
}
