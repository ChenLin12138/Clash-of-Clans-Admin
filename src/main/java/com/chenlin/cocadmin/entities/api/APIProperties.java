package com.chenlin.cocadmin.entities.api;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "api", ignoreUnknownFields = false)
@PropertySource("classpath:api.properties")

public class APIProperties {

	private String membersurl;
	private String clanurl;
	private String currentwar;
	private String token;
	private String playerurl;

	public String getMembersurl() {
		return membersurl;
	}

	public void setMembersurl(String membersurl) {
		this.membersurl = membersurl;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getClanurl() {
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

	public String getPlayerurl() {
		return playerurl;
	}

	public void setPlayerurl(String playerurl) {
		this.playerurl = playerurl;
	}

}
