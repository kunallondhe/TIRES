package com.tires.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.JsonViewResponseBodyAdvice;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tires.web.model.Product;
import com.tires.web.model.ProductJsonResponse;
import com.tires.web.model.Search;
import com.tires.web.services.ProductServices;

@SuppressWarnings("serial")
@Controller
@SessionAttributes("products")
public class SearchController extends Exception {

	@ResponseBody
	@GetMapping(value = "/search", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE } )
	public ProductJsonResponse SearchProduct(@RequestParam("width") int w, @RequestParam("profile") int p,
			@RequestParam("rimsize") int r, HttpSession session) throws JsonProcessingException {
		System.out.println("Search Products");

		ProductJsonResponse respone = new ProductJsonResponse();
	    		
		//ModelAndView mv = new ModelAndView();

		List<Product> products = new ArrayList<Product>();

		ProductServices obj = new ProductServices();

		products = obj.GetProducts(new Search(w, p, r));
		
		//products = obj.GetProducts(s);
		
		//mv.setViewName("product/plp");
		//mv.addObject("products", products);
		//mv.addObject("isProductPresent", true);
		
		ObjectMapper mapper = new ObjectMapper();   
		String jsonString = mapper
		         .writerWithDefaultPrettyPrinter()
		         .withView(Views.Public.class)
		         .writeValueAsString(products);
		
		 respone.setValidated(true);
         respone.setProducts(jsonString);
         
         session.setAttribute("products", products);
         
         return respone;
		
         //return "{\"success\":1}";
	}

}

class Views {
	static class Public {
	}

	static class Internal extends Public {
	}
}
