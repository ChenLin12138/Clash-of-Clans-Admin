package com.admin.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "api", ignoreUnknownFields = false)
@PropertySource("classpath:api.properties")


public class APIProperties {
	
	private String url;
	private String clanurl;
	private String currentwar;
	private String token;
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}public String getClanurl() {
		return clanurl;
	}
	public void setClanurl(String clanurl) {
		this.clanurl = clanurl;
	}
	public String getCurrentwar() {
		return currentwar;
	}
	public void setCurrentwar(String currentwar) {
		this.currentwar = currentwar;
	}
	
}
