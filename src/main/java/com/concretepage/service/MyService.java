package com.concretepage.service;

import com.concretepage.security.fitchconnect.FitchConnectApi;
import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.oauth.OAuth20Service;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class MyService {

    private OAuth20Service service;
    String environment = "-dev";
	String clientId="2k1sl51j0ov2i6tuimsbdk2icv";
	String secret="me8sku3chvb9t9q77udnf2m578l60b8csgv3j3f4bu1vhj8e3ns";
    String callbackURL = "http://localhost:8080/oauth-callback";
    
    @PostConstruct
    private void init(){
        this.service  = new ServiceBuilder(clientId)
                .apiSecret(secret)
    			.callback(callbackURL)
    			.build(FitchConnectApi.instance(environment));
    }


    public OAuth20Service getService() {
        return service;
    }
}
