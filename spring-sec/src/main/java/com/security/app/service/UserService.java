package com.security.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.security.app.model.Users;
import com.security.app.repository.UsersRepository;

@Service
public class UserService {

	
	@Autowired
	private UsersRepository repository;
	
	@Autowired
	private JWTService jwtService;
	
	@Autowired
	private AuthenticationManager authManager;
	
	private BCryptPasswordEncoder encode =new BCryptPasswordEncoder(12);
	
	public Users addUser(Users user) {
		user.setPassword(encode.encode(user.getPassword()));
		return repository.save(user);
		
	}
	
	public List<Users> getListOfUsers(){
		return repository.findAll();
	}

	public Users edit(Users user) {
		user.setPassword(encode.encode(user.getPassword()));
		return repository.save(user);
	}

	public String verify(Users user) {
		Authentication authentication = 
				authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getName(), user.getPassword()));
		
		if(authentication.isAuthenticated()) {
			return jwtService.generateToken(user.getName());
		}
		else {
			return "FAIL";
		}
	}
}
