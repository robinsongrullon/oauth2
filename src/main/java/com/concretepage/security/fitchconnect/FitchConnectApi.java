package com.concretepage.security.fitchconnect;

import com.github.scribejava.core.builder.api.DefaultApi20;
import com.github.scribejava.core.extractors.TokenExtractor;
import com.github.scribejava.core.model.OAuth2AccessToken;

public class FitchConnectApi extends DefaultApi20 {

	private String environment;
	
	protected FitchConnectApi(String environment) {
		this.environment=environment;
	}

	public static FitchConnectApi instance(String env) {
		return new FitchConnectApi(env);
	}

	@Override
	public String getAccessTokenEndpoint() {
		return "https://login.fitchconnect"+environment+".com/oauth/token";
	}

	@Override
	protected String getAuthorizationBaseUrl() {
		return "https://login.fitchconnect"+environment+".com/oauth/authorize";
	}
	
	@Override
    public TokenExtractor<OAuth2AccessToken> getAccessTokenExtractor() {
		return FitchConnectTokenExtractor.instance();
    }

}
