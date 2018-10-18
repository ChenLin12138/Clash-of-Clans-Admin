package com.admin.parser;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.admin.entities.Clandetails;
import com.admin.entities.Currentwar;
import com.admin.entities.Member;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class CurrentWarParser {

	public List<Currentwar> getCurrentWar(String json) {
		List<Currentwar> currentwar = new ArrayList<Currentwar>();
		JSONObject jSONobj = JSONObject.fromObject(json);
		JSONArray items = jSONobj.getJSONArray("clan"); 
		
		return currentwar;
	}

}
