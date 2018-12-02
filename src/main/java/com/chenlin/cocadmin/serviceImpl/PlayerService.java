package com.chenlin.cocadmin.serviceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chenlin.cocadmin.entities.Clandetails;
import com.chenlin.cocadmin.entities.Member;
import com.chenlin.cocadmin.entities.Player;
import com.chenlin.cocadmin.entities.api.APIProperties;
import com.chenlin.cocadmin.parser.ClanParser;
import com.chenlin.cocadmin.parser.MemberParser;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Service
public class PlayerService extends BaseAPIService{
		@Autowired
		private APIProperties properties;
	
		public Player getPlayer(Member member) throws IOException{
		String playerTag = member.getTag().substring(1);
		String rowData = fetchRowData(properties.getPlayerurl().replaceAll("\\{parm\\}", playerTag),properties.getToken());
		JSONObject jSONobj = JSONObject.fromObject(rowData);
		Player player=new Player();
		player.setWarstar(Integer.parseInt(jSONobj.getString("warStars")));
	    return player;
		}
}