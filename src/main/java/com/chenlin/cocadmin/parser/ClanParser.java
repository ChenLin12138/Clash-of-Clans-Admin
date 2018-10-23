package com.chenlin.cocadmin.parser;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.chenlin.cocadmin.entities.Clandetails;
import com.chenlin.cocadmin.entities.Member;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class ClanParser {
	public List<Clandetails> getClans(String json) throws IOException{
		
		List<Clandetails> clans = new ArrayList<Clandetails>();
		JSONObject jSONobj = JSONObject.fromObject(json);
		//JSONArray items = jSONobj.getJSONArray("items"); 
		
		
		//for(int i=0;i<items.size();i++){ 
		//	String item = items.getString(i); 
		//	JSONObject itemObj = JSONObject.fromObject(item); 
			Clandetails clan = new Clandetails();
			clan.setTag(jSONobj.getString("tag"));
			clan.setName(jSONobj.getString("name"));
			//Properties prop = new Properties();  
		   //   FileInputStream fis =   
		   //    new FileInputStream("/home/zdm/eclipse-workspace/coc/Clash-of-Clans-Admin/target/classes/cn.properties");  
		  //  prop.load(fis);  		       
		    clan.setClanLevel(jSONobj.getInt("clanLevel"));
		    clan.setType(jSONobj.getString("type"));
		    clan.setDescription(jSONobj.getString("description"));
		    clan.setClanPoints(jSONobj.getInt("clanPoints"));
		    clan.setRequiredTrophies(jSONobj.getInt("requiredTrophies"));
		    clan.setWarFrequency(jSONobj.getString("warFrequency"));
		    clan.setWarWins(jSONobj.getInt("warWins"));
		    clan.setWarTies(jSONobj.getInt("warTies"));
		    clan.setWarLosses(jSONobj.getInt("warLosses"));
		    clan.setMembers(jSONobj.getInt("members"));
			clans.add(clan);
		//	} 
		//int abb=members.size();
		return clans;
	}
}
