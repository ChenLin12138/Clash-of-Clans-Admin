package com.chenlin.cocadmin.serviceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Service;

import com.chenlin.cocadmin.entities.Clandetails;
import com.chenlin.cocadmin.entities.Member;
import com.chenlin.cocadmin.entities.Warmember;
import com.chenlin.cocadmin.parser.ClanParser;
import com.chenlin.cocadmin.parser.CurrentWarParser;
import com.chenlin.cocadmin.parser.MemberParser;


@Service

public class APIService {
	@Autowired
	private JdbcOperations jdbcOperations;

	public List<Member> getMembers(String url, String token) throws IOException{

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
        
        MemberParser memberParse = new MemberParser();
        return memberParse.getMembers(result.toString()); 
	}

	public List<Clandetails> getClans(String clanurl, String token) throws IOException{

        StringBuilder result = new StringBuilder();
        try {
            URL webUrl = new URL(clanurl);
            
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
        ClanParser clanParse = new ClanParser();
        return clanParse.getClans(result.toString());
	}

	/*public List<Clandetails> getCurrentWar(String currentwar, String token) {
		StringBuilder result = new StringBuilder();
        try {
            URL webUrl = new URL(currentwar);
            
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
        CurrentWarParser currentWarParse = new CurrentWarParser();
        return currentWarParse.getCurrentWar(result.toString());
	}*/
	private static final String INSERT_PRODUCT_SQL = "INSERT INTO waradmin" + "(name,date)"
			+ "VALUES(?,?)";
	public void save(Warmember warmember) {
		jdbcOperations.update(INSERT_PRODUCT_SQL,
				warmember.getName(),
				warmember.getDate()
			
				);
	}

	private static final String GET_PRODUCTS_SQL="SELECT id, date, name FROM waradmin";
	public List<Warmember> showMember() {
		List<Map<String, Object>> resultList = jdbcOperations.queryForList(GET_PRODUCTS_SQL);	
		List<Warmember> warmember = new ArrayList<Warmember>();
		for(Map<String, Object> map: resultList) {
			Warmember ps = new Warmember();
			ps.setId((int)map.get("id"));
			ps.setName((String)map.get("name"));
			ps.setDate((String)map.get("date"));
			warmember.add(ps);
	}
		return warmember;
		
	}
	
}