package com.RN.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/order")
public class OrderController {

	@GetMapping(path = "/")
	public String index() {
		return "order/index";
	}
	
}
