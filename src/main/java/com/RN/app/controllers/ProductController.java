package com.RN.app.controllers;

import java.util.ArrayList;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/product")
public class ProductController {
	
	
	@GetMapping(path = "/")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public String index() {
		return "product/index";
	}
	
	@GetMapping(path = "/create")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public String create(Model model) {
		model.addAttribute("yet", ", still nothing here");
		
		ArrayList<String> words = new ArrayList<>();
		words.add("word 1");
		words.add("word 2");
		words.add("word 3");
		
		model.addAttribute("list", words);
		
		return "product/create";
	}
	
	
	@GetMapping(path = "/edit")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public String edit() {
		return "product/edit";
	}
	
	@GetMapping(path = "/delete")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public String delete() {
		return "product/delete";
	}
	
	
}
