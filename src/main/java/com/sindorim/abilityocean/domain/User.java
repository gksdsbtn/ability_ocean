package com.sindorim.abilityocean.domain;

public class User {

	private String twUserCode;
	private String twUserId;
	private String twUserName;
	private String twUserPwd;
	private String regDt;
	private String enabled;
	
	
	public String getTwUserCode() {
		return twUserCode;
	}
	public void setTwUserCode(String twUserCode) {
		this.twUserCode = twUserCode;
	}
	public String getTwUserId() {
		return twUserId;
	}
	public void setTwUserId(String twUserId) {
		this.twUserId = twUserId;
	}
	public String getTwUserName() {
		return twUserName;
	}
	public void setTwUserName(String twUserName) {
		this.twUserName = twUserName;
	}
	public String getTwUserPwd() {
		return twUserPwd;
	}
	public void setTwUserPwd(String twUserPwd) {
		this.twUserPwd = twUserPwd;
	}
	public String getRegDt() {
		return regDt;
	}
	public void setRegDt(String regDt) {
		this.regDt = regDt;
	}
	public String getEnabled() {
		return enabled;
	}
	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}
	
	
	
}
