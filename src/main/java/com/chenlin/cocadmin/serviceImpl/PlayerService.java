package com.chenlin.cocadmin.serviceImpl;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chenlin.cocadmin.entities.Member;
import com.chenlin.cocadmin.entities.Player;
import com.chenlin.cocadmin.entities.api.APIProperties;
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