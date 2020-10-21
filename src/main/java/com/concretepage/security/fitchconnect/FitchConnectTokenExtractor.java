package com.concretepage.security.fitchconnect;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.scribejava.core.extractors.OAuth2AccessTokenJsonExtractor;


public class FitchConnectTokenExtractor extends OAuth2AccessTokenJsonExtractor {

	protected FitchConnectTokenExtractor() {}
	
	private static class InstanceHolder {
        private static final FitchConnectTokenExtractor INSTANCE = new FitchConnectTokenExtractor();
    }
	
	public static FitchConnectTokenExtractor instance() {
        return InstanceHolder.INSTANCE;
    }
	
	private static String extractFitchId(String sub) {
		return sub.substring(sub.indexOf("/users/")+7);
	}
	
	@Override
    protected FitchConnectAccessToken createToken(String accessToken, String tokenType, Integer expiresIn,
            String refreshToken, String scope, JsonNode response, String rawResponse) {

		final JsonNode subject = response.get("sub");
		final JsonNode profile = response.get("profile");
		
		JsonNode email=null;
		if (null!=profile) {
			email = profile.get("email_address");	
		}
        
        return new FitchConnectAccessToken(accessToken, tokenType, expiresIn, refreshToken, scope,
        		subject == null ? null : subject.asText(),
        		subject == null ? null : extractFitchId(subject.asText()),
        		email == null ? null : email.asText(),
        		rawResponse);
    }
}
