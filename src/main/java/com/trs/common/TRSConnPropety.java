package com.trs.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TRSConnPropety {
	
	public static  String url="";

	public static String username ="";
	
	public static String password = "";
	public static String getUrl() {
		return url;
	}
	@Value(value = "#{propetyConfigure['url']}")
	public  void setUrl(String url) {
		TRSConnPropety.url = url;
	}
	public  String getUsername() {
		return username;
	}
	@Value(value = "#{propetyConfigure['username']}")
	public void setUsername(String username) {
		TRSConnPropety.username = username;
	}
	
	public static String getPassword() {
		return password;
	}
	@Value(value = "#{propetyConfigure['password']}")
	public void setPassword(String password) {
		TRSConnPropety.password = password;
	}
	
}
