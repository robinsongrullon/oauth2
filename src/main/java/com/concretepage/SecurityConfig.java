package com.concretepage;

import javax.servlet.Filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.springframework.boot.autoconfigure.security.oauth2.resource.UserInfoTokenServices;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.MediaType;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.filter.OAuth2ClientAuthenticationProcessingFilter;
import org.springframework.security.oauth2.client.filter.OAuth2ClientContextFilter;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableOAuth2Client
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	OAuth2ClientContext oauth2ClientContext;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/", "/error**").permitAll().anyRequest().permitAll()
		        .and().logout().logoutUrl("/logout").logoutSuccessUrl("/")
		        .and().addFilterBefore(oauth2ClientFilter(), BasicAuthenticationFilter.class);

	}

	@Bean
	@ConfigurationProperties("fc.client")
	public AuthorizationCodeResourceDetails fcClient() {
		return new AuthorizationCodeResourceDetails();
	}

	@Bean
	@ConfigurationProperties("fc.resource")
	public ResourceServerProperties fcResource() {
		return new ResourceServerProperties();
	}
	
	@Bean
	public FilterRegistrationBean<OAuth2ClientContextFilter> oauth2ClientFilterRegistration(
			OAuth2ClientContextFilter filter) {
		FilterRegistrationBean<OAuth2ClientContextFilter> registration = new FilterRegistrationBean<OAuth2ClientContextFilter>();
		registration.setFilter(filter);
		registration.setOrder(Ordered.HIGHEST_PRECEDENCE + 1);
		return registration;
	}	
	
	private Filter oauth2ClientFilter() {
		OAuth2ClientAuthenticationProcessingFilter oauth2ClientFilter = new OAuth2ClientAuthenticationProcessingFilter(
				"/oauth-callback");
		OAuth2RestTemplate restTemplate = new OAuth2RestTemplate(fcClient(), oauth2ClientContext);
		
		restTemplate.setRetryBadAccessTokens(true);
		
		//System.out.println("access token=" + restTemplate.getAccessToken() );
		//System.out.println(" resttemplate: " + restTemplate.toString() );
		oauth2ClientFilter.setRestTemplate(restTemplate);
		
		System.out.println("fcResource().getUserInfoUri() = " + fcResource().getUserInfoUri());
		UserInfoTokenServices tokenServices = new UserInfoTokenServices(fcResource().getUserInfoUri(),
				fcClient().getClientId());
	
		 
		tokenServices.setRestTemplate(restTemplate);
		oauth2ClientFilter.setTokenServices(tokenServices);
		
		return oauth2ClientFilter;
	}	
	
}