package com.chenlin.cocadmin.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class APIPlayerTask implements Callable<String>{

	private final String playerTag;
	
	public APIPlayerTask(String playerTag) {
		this.playerTag = playerTag;
	}
	
	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		
		String palyerInfo = null;
		BaseAPIService baseAPIService = new BaseAPIService();
		String url = "https://api.clashofclans.com/v1/players/%23";
		String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiIsImtpZCI6IjI4YTMxOGY3LTAwMDAtYTFlYi03ZmExLTJjNzQzM2M2Y2NhNSJ9.eyJpc3MiOiJzdXBlcmNlbGwiLCJhdWQiOiJzdXBlcmNlbGw6Z2FtZWFwaSIsImp0aSI6ImU4NDk1YzNmLTdlMzItNDlmYy1iZGM4LWI3MTRiMzU5N2Q5ZSIsImlhdCI6MTU0Mzc0NzA1NCwic3ViIjoiZGV2ZWxvcGVyLzgwYzY0ZGNiLWQwMTYtNDhiZi05MjM5LTcxMDZiYzE0Nzg1NiIsInNjb3BlcyI6WyJjbGFzaCJdLCJsaW1pdHMiOlt7InRpZXIiOiJkZXZlbG9wZXIvc2lsdmVyIiwidHlwZSI6InRocm90dGxpbmcifSx7ImNpZHJzIjpbIjE3MS4yMTcuNjEuODciXSwidHlwZSI6ImNsaWVudCJ9XX0.k7eEemBamj3oja_Oh8x5NxQbLR3v8znGwUFxZjO7z_1ehuREhFC_qW3qjylrx3oI-wFZXbgHbZ5Z1hzSnRC8-w";
		palyerInfo = baseAPIService.fetchRowData(url+playerTag, token);
		return palyerInfo;
	}
	
	public static void main(String[] args) {
		
		List<String> playerTagList = new ArrayList<String>();
		playerTagList.add("209GGLPU9");
		playerTagList.add("PPYU9889U");
		playerTagList.add("P8V90UURL");
		playerTagList.add("8Y98VP928");
		
		List<APIPlayerTask> tasks = new ArrayList<APIPlayerTask>();
		for(String tag: playerTagList) {
			tasks.add(new APIPlayerTask(tag));
		}
		ExecutorService exec = Executors.newFixedThreadPool(5);
		try {
			List<Future<String>> features = exec.invokeAll(tasks);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<String> players = new ArrayList<String>(tasks.size());
		
//		for() {
//			
//		}
	}
		
}
