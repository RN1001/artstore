package com.RN.app.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
	public String registerSubmit(@ModelAttribute @Valid User user, BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
			return "register";
		}
		
		Boolean userExists = repo.existsByUsername(user.getUsername());
		
		System.err.println(repo.findByUsername(user.getUsername()));
		System.err.println(userExists);
		
		if (userExists == true) {
			bindingResult.rejectValue("username", "This username already exists, please use something else.");
			return "register";
		} else {
			repo.save(user);
			return "registerSuccessful";
		}
		
		
	}
	
	
	@GetMapping(path="/testdb")
	public @ResponseBody Iterable<User> getAllUsers() {
		System.err.println(this.repo.findAll());
		
		return this.repo.findAll();
	}
	
}
