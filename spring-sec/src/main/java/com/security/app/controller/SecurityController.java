package com.security.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class SecurityController {
	
	
	@GetMapping("/hello")
	public String greet(HttpServletRequest request) {
		return "Welcome "+request.getSession().getId();
	}
	 

}
