package com.concretepage.service;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountStatusException;
import org.springframework.security.authentication.AuthenticationDetailsSource;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.stereotype.Service;

import com.concretepage.domain.User;
import com.concretepage.security.PmUserDetails;


//@Service
public class UserService {
	/*
	@Autowired
	protected UserDetailsService userDetailsService;
	public void setUserDetailsService(UserDetailsService userDetailsService) {this.userDetailsService=userDetailsService;}

	private final Log logger = LogFactory.getLog(getClass());

	
	public BCryptPasswordEncoder getPasswordEncoder() {return new BCryptPasswordEncoder(12);}
	private AuthenticationDetailsSource<HttpServletRequest, ?> authenticationDetailsSource = new WebAuthenticationDetailsSource();
	
	
	
	/*
	 * Programmatically authenticate the user
	 */
	
	/*
	public void authenticateUser(User theUser, String source, HttpSession session, HttpServletRequest request, Boolean logLogin) throws AccountStatusException {
		
    	try {
    		UserDetails ud = userDetailsService.loadUserByUsername(theUser.getUserEmail());

    		
    		PreAuthenticatedAuthenticationToken token = new PreAuthenticatedAuthenticationToken(ud, ud.getPassword(), ud.getAuthorities());   		
    		token.setDetails(authenticationDetailsSource.buildDetails(request));
    		token.setAuthenticated(true);
		    SecurityContextHolder.getContext().setAuthentication(token);

		   System.out.println("User: "+theUser.getUserEmail()+" session ID is: "+((PmUserDetails) ud).getCurrentSessionId());
		    
		    
    	} catch (AccountStatusException ase) {
    		throw ase;
		} catch (Exception e) {
		     e.printStackTrace();
			   
		}	
	}
	*/
}