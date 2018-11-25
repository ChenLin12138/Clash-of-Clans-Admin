package com.chenlin.cocadmin.parser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.chenlin.cocadmin.entities.Clandetails;
import net.sf.json.JSONObject;

public class ClanParser {
	public List<Clandetails> getClans(String json) throws IOException{
		
		List<Clandetails> clans = new ArrayList<Clandetails>();
		JSONObject jSONobj = JSONObject.fromObject(json); 
			Clandetails clan = new Clandetails();
			clan.setTag(jSONobj.getString("tag"));
			clan.setName(jSONobj.getString("name"));
 		       
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

		return clans;
	}
}
