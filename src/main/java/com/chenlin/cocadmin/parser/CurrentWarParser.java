package com.chenlin.cocadmin.parser;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.chenlin.cocadmin.entities.Clandetails;
import com.chenlin.cocadmin.entities.Currentwar;
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
