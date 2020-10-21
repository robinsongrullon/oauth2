package com.concretepage.security;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.concretepage.domain.User;


@Service
public class PmUserDetailsService implements UserDetailsService {
 
    
	@Override
	public UserDetails loadUserByUsername(String username)  {
		User user = new User();
		user.setUserEmail("mchalli@fitchgroup.co");
		return  (UserDetails) user;
	}
	
	private static List<GrantedAuthority> getGrantedAuthorities(User user) {
    	List<GrantedAuthority> grantedAuths = new ArrayList<GrantedAuthority>();
    	for (String role : user.getUserAuthorities()) {
    		grantedAuths.add(new SimpleGrantedAuthority(role));	
    	}
    	return grantedAuths;
	}

	public void addUserDetailsToSessionAndLog(UserDetails ud, String loginType, HttpServletRequest request) {
		
	}
	
}
