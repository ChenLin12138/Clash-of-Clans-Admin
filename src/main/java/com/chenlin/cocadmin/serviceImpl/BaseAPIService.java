package com.chenlin.cocadmin.serviceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import com.chenlin.cocadmin.service.IAPIService;

public class BaseAPIService implements IAPIService {

	@Override
	public String callAPI(URLConnection uc) {
		StringBuilder result = new StringBuilder();

		try (BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream(),"UTF-8"))) {
			String inputLine = null;
			while ((inputLine = in.readLine()) != null) {
				result.append(inputLine);
			}

			return result.toString();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	protected URLConnection getConnection(String url, String token) {
		URL webUrl;
		URLConnection uc = null;

		try {
			webUrl = new URL(url);
			try {
				uc = webUrl.openConnection();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			uc.setRequestProperty("accept", "/json");
			uc.setRequestProperty("Authorization", token);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return uc;
	}

	public String fetchRowData(String url, String token) {
		URLConnection uc = getConnection(url, token);
		return callAPI(uc);
	}
}
