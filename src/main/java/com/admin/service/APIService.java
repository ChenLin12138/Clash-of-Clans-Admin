package com.admin.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.springframework.stereotype.Service;

import com.admin.model.Member;
import com.admin.parser.MemberParser;

@Service
public class APIService {

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
}
