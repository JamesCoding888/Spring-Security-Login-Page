package com.example.demo.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.example.demo.entity.UserEntity;
import com.example.demo.repository.UserRepository;

@Service
public class UserDetailsService4DBImpl implements UserDetailsService {
	
	@Autowired
    private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		/*
		 * Seeing "LoadUserByUserName: A01" twice in the console is expected behavior in your scenario. 
		 * The first invocation is for the initial login, and the second invocation is for authenticating via the remember-me token.
		 */		
		// System.out.println("LoadUserByUserName: " + username);
		// 1. Verify if user exist
		Optional<UserEntity> opt = userRepository.findByUsername(username);							
		if(!opt.isPresent()) throw new UsernameNotFoundException("Not found!");
		
		// 2. Retrieve user details
		UserEntity user = opt.get();
		String password = user.getPassword();
		String authority = user.getAuthority();
		// Notice! The User class here, is from 'org.springframework.security.core.userdetails.User'
		return new User(username, 
					    password, 
					    AuthorityUtils.commaSeparatedStringToAuthorityList(authority));
	}  
}
