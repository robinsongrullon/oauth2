package com.concretepage.security;

import java.util.Collection;
import java.util.Date;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;


import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=false, onlyExplicitlyIncluded = true)
public class PmUserDetails extends User {

	private static final long serialVersionUID = 1L;

	public PmUserDetails(String username, String password, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
	}
	
	

	// equals&hashcode is for spring security concurrency control
	@EqualsAndHashCode.Include private Integer userId;
	public Integer getUserId() {return this.userId;}
	public void setUserId(Integer i) {this.userId=i;} 
	
	private Integer fulcrumId;
	public Integer getFulcrumId() {return this.fulcrumId;}
	public void setFulcrumId(Integer i) {this.fulcrumId=i;} 

	private String userEmail;
    public void setUserEmail(String s) {this.userEmail = s;}
    public String getUserEmail() {return this.userEmail;}

    private String userFirstName;
	public void setUserFirstName(String s) {this.userFirstName=s;}
	public String getUserFirstName() { return this.userFirstName;}
	
	private String userLastName;
	public void setUserLastName(String s) {this.userLastName=s;}
	public String getUserLastName() { return this.userLastName;}

    

	private String userPacerCredentialsStatus;
	public void setUserPacerCredentialsStatus(String s) {this.userPacerCredentialsStatus=s;}
	public String getUserPacerCredentialsStatus() { return this.userPacerCredentialsStatus;}
	
	private Boolean isFulcrumCustomer;
	public void setIsFulcrumCustomer(Boolean b) {this.isFulcrumCustomer=b;}
	public Boolean getIsFulcrumCustomer() {return this.isFulcrumCustomer;}
	
	private boolean emailVerified;
	public void setEmailVerified(boolean b) {this.emailVerified=b;}
	public boolean getEmailVerified() {return this.emailVerified;}

	private boolean planBillingConfirmed;
	public void setPlanBillingConfirmed(boolean b) {this.planBillingConfirmed=b;}
	public boolean getPlanBillingConfirmed() {return this.planBillingConfirmed;}

	private boolean planBillingSkipped;
	public void setPlanBillingSkipped(boolean b) {this.planBillingSkipped=b;}
	public boolean getPlanBillingSkipped() {return this.planBillingSkipped;}

	private boolean accountEnabled;
	public void setAccountEnabled(boolean b) {this.accountEnabled=b;}
	public boolean getAccountEnabled() {return this.accountEnabled;}

	private boolean accountSuspended;
	public void setAccountSuspended(boolean b) {this.accountSuspended=b;}
	public boolean getAccountSuspended() {return this.accountSuspended;}

	private boolean accountBillingHold;
	public void setAccountBillingHold(boolean b) {this.accountBillingHold=b;}
	public boolean getAccountBillingHold() {return this.accountBillingHold;}

	private boolean accountFraudHold;
	public void setAccountFraudHold(boolean b) {this.accountFraudHold=b;}
	public boolean getAccountFraudHold() {return this.accountFraudHold;}
    
	private boolean hasCreditCardOnFile;
	public void setHasCreditCardOnFile(boolean b) {this.hasCreditCardOnFile=b;}
	public boolean getHasCreditCardOnFile() {return this.hasCreditCardOnFile;}

	private String currentSessionId;
	public String getCurrentSessionId() {return this.currentSessionId;}
	public void setCurrentSessionId(String s) {this.currentSessionId=s;}

	private boolean linkedinConnected;
	public boolean isLinkedinConnected() { return linkedinConnected; }
	public void setLinkedinConnected(boolean linkedinConnected) { this.linkedinConnected = linkedinConnected; }

	private Date trialExpirationDate;
	public void setTrialExpirationDate(Date d) {this.trialExpirationDate=d;}
	public Date getTrialExpirationDate() {return this.trialExpirationDate;}

	private Boolean forcePasswordChange;
	public void setForcePasswordChange(Boolean b) {this.forcePasswordChange=b;}
	public Boolean getForcePasswordChange() {return this.forcePasswordChange;}

	// Intercom.io variables
	private long userSignupTimestamp;
	public long getUserSignupTimestamp() {return this.userSignupTimestamp; }
	public void setUserSignupTimestamp(long l) {this.userSignupTimestamp=l; }
	
	public String userVerifyHash;
	public String getUserVerifyHash() {return this.userVerifyHash;}
	public void setUserVerifyHash(String s) {this.userVerifyHash=s;}
	
}
