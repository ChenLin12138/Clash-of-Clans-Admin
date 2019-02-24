package com.chenlin.cocadmin.task;

import java.util.concurrent.Callable;

import com.chenlin.cocadmin.serviceImpl.BaseAPIService;

public class APIPlayerTask implements Callable<String> {

	private final String url;
	private final String token;

	public APIPlayerTask(String url, String token) {
		this.url = url;
		this.token = token;
	}

	@Override
	public String call() throws Exception {
		String palyerInfo = null;
		BaseAPIService baseAPIService = new BaseAPIService();
		palyerInfo = baseAPIService.fetchRowData(url, token);
		return palyerInfo;
	}
}
