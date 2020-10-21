package  com.concretepage.security.fitchconnect;

import com.github.scribejava.core.model.OAuth2AccessToken;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode(callSuper=true)
public class FitchConnectAccessToken extends OAuth2AccessToken {

	private static final long serialVersionUID = 7577758998225166421L;
	
	@Getter private final String subject;
	@Getter private final String fitchConnectId;
	@Getter private final String email;
	
	public FitchConnectAccessToken(String accessToken, String tokenType, Integer expiresIn, String refreshToken,
            String scope, String subject, String fitchConnectId, String email, String rawResponse) {
        super(accessToken, tokenType, expiresIn, refreshToken, scope, rawResponse);
        this.subject = subject;
        this.fitchConnectId = fitchConnectId;
        this.email = email;
    }
	
}
