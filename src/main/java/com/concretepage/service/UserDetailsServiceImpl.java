package com.concretepage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.concretepage.domain.User;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	//@Autowired
	//UserRepository userRepository;

	
	public UserDetails loadUserByUsername(String username)  {
		User user = new User("user1", "myemail", "pass");

		return UserDetailsImpl.build(user);
	}
	
	
	public UserDetails buildUser(String userName, String email, String firstName, String lastName, String fitchUserId)  {
		User user = new User(userName, email, email);
		user.setUserFirmName(firstName);
		user.setUserLastName(lastName);
		user.setUserFitchConnectId(fitchUserId);

		return UserDetailsImpl.build(user);
	}
	

}