package com.chenlin.cocadmin.parser;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import java.util.List;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.chenlin.cocadmin.entities.Member;
import com.chenlin.cocadmin.entities.api.APIProperties;
import com.chenlin.cocadmin.serviceImpl.PlayerService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class MemberParser {
	
	
	public List<Member> getMembers(String json) throws IOException{
			
		List<Member> members = new ArrayList<Member>();
		JSONObject jSONobj = JSONObject.fromObject(json);
		JSONArray items = jSONobj.getJSONArray("items"); 
		
		
		for(int i=0;i<items.size();i++){ 
			String item = items.getString(i); 
			JSONObject itemObj = JSONObject.fromObject(item); 
			Member member = new Member();
			member.setTag(itemObj.getString("tag"));
			
			String getPlayerTag = itemObj.getString("tag").substring(1);
//			properties.getPlayerurl();
			String playerurl="https://api.clashofclans.com/v1/players/%23"+getPlayerTag;
			String token="Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiIsImtpZCI6IjI4YTMxOGY3LTAwMDAtYTFlYi03ZmExLTJjNzQzM2M2Y2NhNSJ9.eyJpc3MiOiJzdXBlcmNlbGwiLCJhdWQiOiJzdXBlcmNlbGw6Z2FtZWFwaSIsImp0aSI6IjJmY2RkZDE0LTFkODYtNGM0ZS1iZTUyLTAwMjkzZGYwNmQ3MiIsImlhdCI6MTU0MzMwODA4NCwic3ViIjoiZGV2ZWxvcGVyLzgwYzY0ZGNiLWQwMTYtNDhiZi05MjM5LTcxMDZiYzE0Nzg1NiIsInNjb3BlcyI6WyJjbGFzaCJdLCJsaW1pdHMiOlt7InRpZXIiOiJkZXZlbG9wZXIvc2lsdmVyIiwidHlwZSI6InRocm90dGxpbmcifSx7ImNpZHJzIjpbIjExMC4xODQuMjA1LjkzIl0sInR5cGUiOiJjbGllbnQifV19.AVaswWq2mpGPAuYJxGHPel8DG-RTHD4GygIlosQw8QSwHJDfOsfzgwmlnRKg6IuBDOQSVbrrikraVAyiQ0WGzg ";
			PlayerService playerservice=new PlayerService();
			int warstar=playerservice.getPlayers(playerurl,token);
			member.setWarstar(warstar);
			
			member.setName(itemObj.getString("name"));
			Properties prop = new Properties();  
		    Resource resource = new ClassPathResource("cn.properties");
		    File file = resource.getFile();
		    FileInputStream fis = new FileInputStream(file); 	      
		    prop.load(fis);  		       
			member.setPosition(prop.getProperty(itemObj.getString("role")));
			member.setDonations(Integer.parseInt(itemObj.getString("donations")));
			member.setDonationsreceived(Integer.parseInt(itemObj.getString("donationsReceived")));
			members.add(member);
			} 
		return members;
	}
}
