package com.RN.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.RN.app.models.User;
import com.RN.app.repositories.UserRepository;

@Controller
@RequestMapping(path="/")
public class HomeController {
	
	@Autowired
	private UserRepository repo;
	
	@GetMapping(path="/")
	public String index() {
		return "index";
	}
	
	@GetMapping(path="/products")
	public String products() {
		return "products";
	}
	
	@GetMapping(path="/login")
	public String login() {
		return "login";
	}
	
	@GetMapping(path="/register")
	public String register(Model model) {
		model.addAttribute("user", new User());
		return "register";
	}
	
	@PostMapping(path="/register")
	public String registerSubmit(@ModelAttribute User user) {
		
		repo.save(user);
		
		return "registerSuccessful";
	}
	
	
	@GetMapping(path="/testdb")
	public @ResponseBody Iterable<User> getAllUsers() {
		System.err.println(this.repo.findAll());
		
		return this.repo.findAll();
	}
	
}
