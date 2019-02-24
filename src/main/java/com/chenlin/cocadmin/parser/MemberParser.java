package com.chenlin.cocadmin.parser;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.chenlin.cocadmin.entities.Member;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class MemberParser {

	public List<Member> getMembers(String json) throws IOException {

		List<Member> members = new ArrayList<Member>();
		JSONObject jSONobj = JSONObject.fromObject(json);
		JSONArray items = jSONobj.getJSONArray("items");

		for (int i = 0; i < items.size(); i++) {
			String item = items.getString(i);
			JSONObject itemObj = JSONObject.fromObject(item);
			Member member = new Member();
			member.setTag(itemObj.getString("tag"));
			member.setName(itemObj.getString("name"));
			Properties prop = new Properties();
			Resource resource = new ClassPathResource("cn.properties");

			prop.load(new InputStreamReader(resource.getInputStream(), "UTF-8"));

			member.setPosition(prop.getProperty(itemObj.getString("role")));
			member.setDonations(Integer.parseInt(itemObj.getString("donations")));
			member.setDonationsReceived(Integer.parseInt(itemObj.getString("donationsReceived")));
			members.add(member);
		}
		return members;
	}
}
