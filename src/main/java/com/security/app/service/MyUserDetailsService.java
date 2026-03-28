package com.security.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.security.app.model.UserPrincipal;
import com.security.app.model.Users;
import com.security.app.repository.UsersRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UsersRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		Users user = repository.findByName(username);
		if(user == null) {
			throw new UsernameNotFoundException("user not found");
		}
		return new UserPrincipal(user);
	}

}
