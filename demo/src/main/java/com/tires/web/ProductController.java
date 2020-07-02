package com.tires.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tires.web.services.ProductServices;

@Controller
public class ProductController {
	@RequestMapping("/add")
	public void Add() {
		ProductServices obj = new ProductServices();
		
		obj.SaveProduct(null);
	}
}
