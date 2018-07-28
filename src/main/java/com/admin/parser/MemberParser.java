package com.admin.parser;

import java.util.ArrayList;
import java.util.List;

import com.admin.model.Member;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class MemberParser {
	
	
	public List<Member> getMembers(String json){
			
		List<Member> members = new ArrayList<Member>();
		JSONObject jSONobj = JSONObject.fromObject(json);
		JSONArray items = jSONobj.getJSONArray("items"); 
		
		
		for(int i=0;i<items.size();i++){ 
			String item = items.getString(i); 
			JSONObject itemObj = JSONObject.fromObject(item); 
			Member member = new Member();
			member.setTag(itemObj.getString("tag"));
			member.setName(itemObj.getString("name"));
			member.setDonations(Integer.parseInt(itemObj.getString("donations")));
			member.setDonationsReceived(Integer.parseInt(itemObj.getString("donationsReceived")));
			members.add(member);
			} 
		
		return members;
	}
}
