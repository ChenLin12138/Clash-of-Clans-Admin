package com.chenlin.cocadmin.serviceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.springframework.stereotype.Service;

import com.chenlin.cocadmin.entities.Member;
import com.chenlin.cocadmin.parser.MemberParser;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Service
public class PlayerService {
	public int getPlayers(String url, String token) throws IOException{

        StringBuilder result = new StringBuilder();
        try {
            URL webUrl = new URL(url);
            
            URLConnection uc = webUrl.openConnection();
            uc.setRequestProperty("accept", "/json");
            uc.setRequestProperty("Authorization", token);
            BufferedReader in = new BufferedReader(new InputStreamReader(
                                        uc.getInputStream()));
            String inputLine = null;
            while ( (inputLine = in.readLine()) != null) {
            	result.append(inputLine);
            }
            in.close();
        } catch (MalformedURLException e) {
        } catch (IOException e) {
        }
        
      //  MemberParser memberParse = new MemberParser();
     //   return memberParse.getMembers(result.toString()); 
        JSONObject jSONobj = JSONObject.fromObject(result.toString());
 		return Integer.parseInt(jSONobj.getString("warStars"));
		
		
	}
}
