/*
 */
package com.concretepage.domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Joe
 *
 */
public class User implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 3L;

	private Integer userId;
	private Integer userFulcrumId;
	private String  userLinkedinId;
	@Getter @Setter String userFitchConnectId;
	private String  userEcfInbox;
	private String  userPass;
	private String  userPassNew;
	private String  userPassConfirm;
	private String  userFirstName;
	private String  userLastName;
	private String  userFullName;
	private String  userEmail;
	private String  userEmailNewInput;
	@Getter @Setter private String  userEmailNewInputConfirm;
    private String  userEmailOld;
	private String  userFirmName;
	@Getter @Setter 
	private String password;
	private byte[] userEncryptedDataKey;
	private String userEncryptedDataContext;

	@Getter @Setter private String userApiSecretKey;
	
	private String userPacerUsernameInput;
	private String userPacerUsername;
	private byte[] userPacerPassword;
	private String userPacerPasswordInput;
	private String userPacerCredentialsStatus;
	private String userPacerCredentialsAccountType;

	private boolean accountEnabled;
	private boolean accountSuspended;
	private boolean accountBillingHold;
	private boolean accountFraudHold;
	
	private boolean emailVerified;
	
	private Boolean pmInfoEmailEnabled;
	private boolean agreeToTOS;
	private Boolean forcePasswordChange;
	
	private Set<String> userAuthorities;
	
	private Boolean userAlertSendOnEmpty;
	private Boolean userAlertGroupEmails;
	private Boolean userAlertSendWeeklyUsage;
	@Getter @Setter
	private String username;

	private Integer customerDownloadCredits;

	public User(String username, String email, String password) {
		this.username = username;
		this.userEmail = email;
		
		this.password = password;
	}

	@Getter @Setter private Boolean customerIsTaxExempt;
	
	private Integer billingDayOfMonth;
	private boolean planBillingConfirmed;
	private boolean planBillingSkipped;
	private String  planBillingFrequency;
	private Integer planDiscountPercentage;
	private Date    planDiscountEndDate;
	
	private Date signupDate;
	private Date trialExpirationDate;
	private Date upgradeDate;


	
	private boolean defaultDownloadInBackground;
	
	private String linkedinLocation;
	private String linkedinProfileJSON;
	private Date   linkedinConnectionTs;
	
	private String dropboxOAuthToken;

	private String crmContactId;
	private String campaignCode;
	private String gaClientCode;
	private String optimizelyCode;
	private String emailVerifyResults;
	private String emailNormalized;

	// refactor these away
	private String defaultCaseType;
	public void setDefaultCaseType(String s) {this.defaultCaseType=s;}
	public String getDefaultCaseType() { return this.defaultCaseType;}

	// don't persist.  use in the form validation to add to set
	private String userAdminNoteSubmit;
	public void setUserAdminNoteSubmit(String s) {this.userAdminNoteSubmit=s;}
	public String getUserAdminNoteSubmit() {return this.userAdminNoteSubmit;}
	
	// don't persist.  required for signup process
	private Boolean signupAcknowledgePacerRequired;
	public void setSignupAcknowledgePacerRequired(Boolean b) {this.signupAcknowledgePacerRequired=b;}
	public Boolean getSignupAcknowledgePacerRequired() {return this.signupAcknowledgePacerRequired;}
	
	public void setUserId(Integer i) {this.userId=i;}
	public Integer getUserId() {return this.userId;}
	public void setUserPass(String s) {this.userPass=s;}
	public String getUserPass() { return this.userPass;}

	public void setUserFulcrumId(Integer i) {this.userFulcrumId=i;}
	public Integer getUserFulcrumId() {return this.userFulcrumId;}
	
	public void setUserLinkedinId(String s) {this.userLinkedinId=s;}
	public String getUserLinkedinId() { return this.userLinkedinId;}

	public void setUserEcfInbox(String s) {this.userEcfInbox=s;}
	public String getUserEcfInbox() { return this.userEcfInbox;}
	
	public void setUserPassNew(String s) {this.userPassNew=s;}
	public String getUserPassNew() { return this.userPassNew;}
	
	public void setUserPassConfirm(String s) {this.userPassConfirm=s;}
	public String getUserPassConfirm() { return this.userPassConfirm;}
	
	public void setUserFirstName(String s) {this.userFirstName=s;}
	public String getUserFirstName() { return this.userFirstName;}
	
	public void setUserLastName(String s) {this.userLastName=s;}
	public String getUserLastName() { return this.userLastName;}
	
	public void setUserFullName(String s) {this.userFullName=s;}
	public String getUserFullName() { return this.userFullName;}
	
	public void setUserEmail(String s) {this.userEmail=s;}
	public String getUserEmail() { return this.userEmail;}
	
    public void setUserEmailOld(String s) {this.userEmailOld =s;}
    public String getUserEmailOld() { return this.userEmailOld;}

    public void setUserEmailNewInput(String s) {this.userEmailNewInput =s;}
    public String getUserEmailNewInput() { return this.userEmailNewInput;}

	public void setUserFirmName(String s) {this.userFirmName=s;}
	public String getUserFirmName() { return this.userFirmName;}
	
	public void setUserPacerUsernameInput(String s) {this.userPacerUsernameInput=s;}
	public String getUserPacerUsernameInput() { return this.userPacerUsernameInput;}
	
	public void setUserPacerPasswordInput(String s) {this.userPacerPasswordInput=s;}
	public String getUserPacerPasswordInput() { return this.userPacerPasswordInput;}
	
	public void setUserEncryptedDataKey(byte[] b) {this.userEncryptedDataKey=b;}
	public byte[] getUserEncryptedDataKey() { return this.userEncryptedDataKey;}
	
	public void setUserEncryptedDataContext(String s) {this.userEncryptedDataContext=s;}
	public String getUserEncryptedDataContext() { return this.userEncryptedDataContext;}

	public void setAccountEnabled(boolean b) {this.accountEnabled=b;}
	public boolean getAccountEnabled() {return this.accountEnabled;}

	public void setAccountSuspended(boolean b) {this.accountSuspended=b;}
	public boolean getAccountSuspended() {return this.accountSuspended;}

	public void setAccountBillingHold(boolean b) {this.accountBillingHold=b;}
	public boolean getAccountBillingHold() {return this.accountBillingHold;}

	public void setAccountFraudHold(boolean b) {this.accountFraudHold=b;}
	public boolean getAccountFraudHold() {return this.accountFraudHold;}

	public void setUserPacerUsername(String s) {this.userPacerUsername=s;}
	public String getUserPacerUsername() { return this.userPacerUsername;}

	public void setUserPacerPassword(byte[] b) {this.userPacerPassword=b;}
	public byte[] getUserPacerPassword() { return this.userPacerPassword;}

	public void setUserPacerCredentialsStatus(String s) {this.userPacerCredentialsStatus=s;}
	public String getUserPacerCredentialsStatus() { return this.userPacerCredentialsStatus;}

	public void setUserPacerCredentialsAccountType(String s) {this.userPacerCredentialsAccountType=s;}
	public String getUserPacerCredentialsAccountType() { return this.userPacerCredentialsAccountType;}


	public void setPmInfoEmailEnabled(Boolean b) {this.pmInfoEmailEnabled=b;}
	public Boolean getPmInfoEmailEnabled() {return this.pmInfoEmailEnabled;}

	public void setUserAlertSendOnEmpty(Boolean b) {this.userAlertSendOnEmpty=b;}
	public Boolean getUserAlertSendOnEmpty() {return this.userAlertSendOnEmpty;}
	
	public void setUserAlertGroupEmails(Boolean b) {this.userAlertGroupEmails=b;}
	public Boolean getUserAlertGroupEmails() {return this.userAlertGroupEmails;}

	public void setUserAlertSendWeeklyUsage(Boolean b) {this.userAlertSendWeeklyUsage=b;}
	public Boolean getUserAlertSendWeeklyUsage() {return this.userAlertSendWeeklyUsage;}

	public Set<String> getUserAuthorities() {return this.userAuthorities;}
	public void setUserAuthorities(Set<String> l) {this.userAuthorities=l;}

	public void setBillingDayOfMonth(Integer i) {this.billingDayOfMonth=i;}
	public Integer getBillingDayOfMonth() {return this.billingDayOfMonth;}

	public void setPlanBillingConfirmed(boolean b) {this.planBillingConfirmed=b;}
	public boolean getPlanBillingConfirmed() {return this.planBillingConfirmed;}

	public void setPlanBillingSkipped(boolean b) {this.planBillingSkipped=b;}
	public boolean getPlanBillingSkipped() {return this.planBillingSkipped;}

	public void setPlanBillingFrequency(String s) {this.planBillingFrequency=s;}
	public String getPlanBillingFrequency() { return this.planBillingFrequency;}
	
	public void setPlanDiscountPercentage(Integer i) {this.planDiscountPercentage=i;}
	public Integer getPlanDiscountPercentage() {return this.planDiscountPercentage;}

	public void setPlanDiscountEndDate(Date d) {this.planDiscountEndDate=d;}
	public Date getPlanDiscountEndDate() {return this.planDiscountEndDate;}
	
	public void setAgreeToTOS(boolean b) {this.agreeToTOS=b;}
	public boolean getAgreeToTOS() {return this.agreeToTOS;}
	
	public void setForcePasswordChange(Boolean b) {this.forcePasswordChange=b;}
	public Boolean getForcePasswordChange() {return this.forcePasswordChange;}

	public void setSignupDate(Date d) {this.signupDate=d;}
	public Date getSignupDate() {return this.signupDate;}

	public void setTrialExpirationDate(Date d) {this.trialExpirationDate=d;}
	public Date getTrialExpirationDate() {return this.trialExpirationDate;}
	
	
	public void setUpgradeDate(Date d) {this.upgradeDate=d;}
	public Date getUpgradeDate() {return this.upgradeDate;}

	public void setDefaultDownloadInBackground(boolean b) {this.defaultDownloadInBackground=b;}
	public boolean getDefaultDownloadInBackground() {return this.defaultDownloadInBackground;}
	
	public void setLinkedinConnectionTs(Date d) {this.linkedinConnectionTs=d;}
	public Date getLinkedinConnectionTs() { return this.linkedinConnectionTs;}
	
	public void setDropboxOAuthToken(String s) {this.dropboxOAuthToken=s;}
	public String getDropboxOAuthToken() { return this.dropboxOAuthToken;}

	public void setLinkedinLocation(String s) {this.linkedinLocation=s;}
	public String getLinkedinLocation() { return this.linkedinLocation;}

	public void setLinkedinProfileJSON(String s) {this.linkedinProfileJSON=s;}
	public String getLinkedinProfileJSON() { return this.linkedinProfileJSON;}

	public void setCrmContactId(String s) {this.crmContactId=s;}
	public String getCrmContactId() { return this.crmContactId;}

	public void setCampaignCode(String s) {this.campaignCode=s;}
	public String getCampaignCode() { return this.campaignCode;}

	public void setGaClientCode(String s) {this.gaClientCode=s;}
	public String getGaClientCode() { return this.gaClientCode;}
	
	public void setOptimizelyCode(String s) {this.optimizelyCode=s;}
	public String getOptimizelyCode() { return this.optimizelyCode;}

	public void setEmailVerifyResults(String s) {this.emailVerifyResults=s;}
	public String getEmailVerifyResults() { return this.emailVerifyResults;}

	public void setEmailNormalized(String s) {this.emailNormalized=s;}
	public String getEmailNormalized() { return this.emailNormalized;}
	private Set<Role> roles = new HashSet<>();

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
}
