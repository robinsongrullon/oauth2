package com.concretepage.web;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountStatusException;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.concretepage.security.fitchconnect.FitchConnectAccessToken;
import com.concretepage.security.fitchconnect.FitchConnectApi;
import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.oauth.OAuth20Service;
import com.google.common.base.Strings;

@Controller
public class FitchConnectController {

	private final Log logger = LogFactory.getLog(getClass());

  
	
    @Autowired
	private HttpServletRequest request;
	
    private OAuth20Service getService(String callbackURL) {
    	//String environment = (appConfig.isDevelopmentSever()) ? "-stg" : "";
    	//we're using fitch prod for everything for now
    	String environment = "-dev";
    	
    	String clientId="2k1sl51j0ov2i6tuimsbdk2icv";
    	String secret="me8sku3chvb9t9q77udnf2m578l60b8csgv3j3f4bu1vhj8e3ns";
    	
    	return new ServiceBuilder(clientId)
                .apiSecret(secret)
    			.callback(callbackURL)
    			.build(FitchConnectApi.instance(environment));
    }
    
	@RequestMapping({"/login"})
    public String showFitchConnectAuth( Model model, HttpSession session, HttpServletResponse response) {
		System.out.println("FitchConnect Login Starting....");
		
		String oauthState=UUID.randomUUID().toString();
		session.setAttribute("oauthState", oauthState);
		
    	String currentURL = request.getRequestURL().toString();
    	String callbackURL = currentURL.replace("/login", "/oauth-callback");
    	if (callbackURL.contains(";")) callbackURL=callbackURL.substring(0, callbackURL.indexOf(";")); // strip the jsessionid
    	System.out.println("callback="+callbackURL);
		
		try (OAuth20Service service = getService(callbackURL)) {
			String authUrl = service.createAuthorizationUrlBuilder().state(oauthState).build();
			System.out.println("FitchConnect Login Redirecting to url="+authUrl);
	    	return "redirect:"+authUrl;
		} catch (IOException e) {
			e.printStackTrace();
		}
		
    	return "redirect:/login";
	}
	
	/*
	 * 
	 */
	private void validateOauthResponse(HttpSession session, String oauthCode, String returnedState)  {
    	// make sure the code exists
		if (Strings.isNullOrEmpty(oauthCode)) {
    		System.out.println("NO OAUTH CODE!");
    	} else System.out.println("Oauth code exists!");
		
		// validate the state matches
		Object storedState = session.getAttribute("oauthState");
		if (null==storedState) {
			System.out.println("THERE IS NO STATE IN THE SESSION. SESSION EXPIRED.");
			throw new UnsupportedOperationException("Unable to validate state on oauth return");
		} else if (storedState.toString().equals(returnedState)) {
			System.out.println("RETURNED STATE MATCHES STORED STATE.  PROCEED!");
		} else {
			System.out.println("FAILED TO VALIDATE RETURNED STATE!");
			System.out.println("Stored: "+storedState.toString());
			System.out.println("Returned: "+returnedState);
			throw new UnsupportedOperationException("Unable to validate state on oauth return");
		}
	}
	
    @RequestMapping("/oauth-callback2")
    public String doFitchConnectAuth(Model model, HttpSession session, HttpServletResponse response,
    		@RequestParam(value="code",required=false) String oauthCode,
    		@RequestParam(value="state",required=false) String oauthState) {
    	System.out.println("got here");
    	
    	String oauthErrorMessage = null;
    	FitchConnectAccessToken token = null;
    	try {
    		String theUser = null;
        	// make sure state is valid
    		validateOauthResponse(session,oauthCode,oauthState);

        	System.out.println("about to get access token");
        	System.out.println("oauthCode:"+oauthCode);
        	System.out.println("got service...");
    		
        	System.out.println("**********");
        	System.out.println(request.getRequestURL().toString() );
        	
        	try (OAuth20Service service = getService("http://localhost:8080/oauth-callback")) {
            	token = (FitchConnectAccessToken) service.getAccessToken(oauthCode);
        		System.out.println("Access Token: "+token.getAccessToken());
    			System.out.println("Subject: "+token.getSubject());
    			System.out.println("FitchConnectId: "+token.getFitchConnectId());
    			System.out.println("Email: "+token.getEmail());
    			theUser = token.getEmail();
        	}
        	catch(Exception e) {
        		e.printStackTrace();
        	}
			
			
			if(token != null) {
		      System.out.println("fitconnect user id = " + token.getFitchConnectId() );
						
			
				authenticateUser(theUser, "W", session, request, true);
			
				SavedRequest savedRequest = new HttpSessionRequestCache().getRequest(request, response);
				if (null==savedRequest) {
					return "redirect:/dashboard";
				} else {
					System.out.println("got savedrequest: "+savedRequest.getRedirectUrl());
					return "redirect:"+savedRequest.getRedirectUrl();
				}
			}
    	} catch (AccountStatusException ase) {
    		
		}
    	
    	if (null==oauthErrorMessage) oauthErrorMessage="We were unable to process this login. Please try again or contact support.";
    	System.out.println("Login failed: going back to login page....");
    	model.addAttribute("oauthErrorMessage", oauthErrorMessage);

    	
    	return "complete" ;
    }


/*
 * Programmatically authenticate the user
 */
private void authenticateUser(String theUserEmail, String source, HttpSession session, HttpServletRequest request, Boolean logLogin) throws AccountStatusException {
	
	System.out.println("here authenticate the user");
	
}

	
}
