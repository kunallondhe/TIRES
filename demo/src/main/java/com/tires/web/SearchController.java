package com.tires.web;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.tires.web.model.Product;
import com.tires.web.model.ProductJsonResponse;
import com.tires.web.model.Search;
import com.tires.web.services.ProductServices;

@Controller
@SessionAttributes("products")
public class SearchController extends Exception {

	@GetMapping("/bysizeform")
	public String bysizeform() {
		return "shared/bysizeform";
	}

	@ResponseBody
	@GetMapping(value = "/searchbysize", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ProductJsonResponse SearchBySize(@ModelAttribute @Valid Search s, BindingResult result,
			HttpSession session) {

		ProductJsonResponse respone = new ProductJsonResponse();

		if (result.hasErrors()) {

			Map<String, String> errors = result.getFieldErrors().stream()
					.collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));

			respone.setValidated(false);
			respone.setErrorMessages(errors);
		} else {
			List<Product> products = new ArrayList<Product>();

			ProductServices obj = new ProductServices();

			products = obj.GetProducts(s);
			respone.setValidated(true);
			session.setAttribute("products", products);
		}

		return respone;
	}
}
