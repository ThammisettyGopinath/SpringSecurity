package com.security.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.security.app.model.Users;
import com.security.app.service.UserService;

@RestController
public class UserController {

	
	@Autowired
	private UserService userService;
	
	@PostMapping("/add")
	public Users addUser(@RequestBody Users user) {
		return userService.addUser(user);
	}
	
	@GetMapping("/getUsers")
	public List<Users> getListOfUsers(){
		return userService.getListOfUsers();
	}
	
	@PutMapping("/edit/{id}")
	public Users edit(@RequestBody Users user, @PathVariable int id) {
		user.setId(id);
		return userService.edit(user);
	}
	
	@PostMapping("/login")
	public String login(@RequestBody Users user) {
//		return "SUCCESS";
		return userService.verify(user);
	}
}
