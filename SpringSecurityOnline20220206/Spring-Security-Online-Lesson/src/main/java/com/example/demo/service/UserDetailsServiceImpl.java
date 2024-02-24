package com.example.demo.service;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.example.demo.repository.UserDao;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UserDao userDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// 1. Verify if user exist
		Optional<Entry<String, Map<String, String>>> opt = userDao.users.
				entrySet().
				stream().
				filter((Entry<String, Map<String, String>> e) -> e.getKey().equals(username)).
				findFirst();								
		if(!opt.isPresent()) throw new UsernameNotFoundException("Not found!");
		
		// 2. Require the related data and verify the password
		Map<String, String> info = opt.get().getValue();
		String password = info.get("password");
		String authority = info.get("authority");
		// Notice! The User class here, is from 'org.springframework.security.core.userdetails.User'
		return new User(username, 
					    password, 
					    AuthorityUtils.commaSeparatedStringToAuthorityList(authority));
	}  
}
