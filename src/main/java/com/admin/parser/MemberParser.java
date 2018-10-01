package com.admin.parser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import java.util.List;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;

import com.admin.model.Member;

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
			member.setName(itemObj.getString("name"));
			Properties prop = new Properties();  
		      FileInputStream fis =   
		       new FileInputStream("/home/zdm/eclipse-workspace/coc/Clash-of-Clans-Admin/target/classes/cn.properties");  
		    prop.load(fis);  		       
			member.setPosition(prop.getProperty(itemObj.getString("role")));
			member.setDonations(Integer.parseInt(itemObj.getString("donations")));
			member.setDonationsReceived(Integer.parseInt(itemObj.getString("donationsReceived")));
			members.add(member);
			} 
		//int abb=members.size();
		return members;
	}
}
