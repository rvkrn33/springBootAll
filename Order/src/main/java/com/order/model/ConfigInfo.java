package com.order.model;

import org.springframework.stereotype.Component;

@Component
public class ConfigInfo {

	private boolean basicSecurity;
	private boolean oAuth2;
	private boolean JWT;
	private boolean actuator;
	private boolean swagger;
	private boolean devtools;
	public ConfigInfo(){}
	
	public boolean isBasicSecurity() {
		return basicSecurity;
	}
	public void setBasicSecurity(boolean basicSecurity) {
		this.basicSecurity = basicSecurity;
	}
	public boolean isoAuth2() {
		return oAuth2;
	}
	public void setoAuth2(boolean oAuth2) {
		this.oAuth2 = oAuth2;
	}
	public boolean isJWT() {
		return JWT;
	}
	public void setJWT(boolean jWT) {
		JWT = jWT;
	}
	public boolean isActuator() {
		return actuator;
	}
	public void setActuator(boolean actuator) {
		this.actuator = actuator;
	}
	public boolean isSwagger() {
		return swagger;
	}
	public void setSwagger(boolean swagger) {
		this.swagger = swagger;
	}
	public boolean isDevtools() {
		return devtools;
	}
	public void setDevtools(boolean devtools) {
		this.devtools = devtools;
	}
	
	
}
