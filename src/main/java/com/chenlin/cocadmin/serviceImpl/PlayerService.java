package com.chenlin.cocadmin.serviceImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chenlin.cocadmin.entities.Member;
import com.chenlin.cocadmin.entities.Player;
import com.chenlin.cocadmin.entities.api.APIProperties;
import com.chenlin.cocadmin.task.APIPlayerTask;

import net.sf.json.JSONObject;

@Service
public class PlayerService extends BaseAPIService {

	@Autowired
	private APIProperties properties;

	ExecutorService exec = Executors.newFixedThreadPool(20);

	public Player getPlayer(Member member) throws IOException {
		String playerTag = member.getTag().substring(1);
		String rowData = fetchRowData(properties.getPlayerurl().replaceAll("\\{parm\\}", playerTag),
				properties.getToken());
		JSONObject jSONobj = JSONObject.fromObject(rowData);
		Player player = new Player();
		player.setTag(jSONobj.getString("tag"));
		player.setWarstar(Integer.parseInt(jSONobj.getString("warStars")));
		return player;
	}

	@Deprecated
	public Map<String, Player> getPlayersSerial(List<Member> members) throws IOException {

		Map<String, Player> players = new HashMap<String, Player>(64);

		for (Member member : members) {
			Player player = getPlayer(member);
			players.put(player.getTag(), player);
		}

		return new HashMap<String, Player>(players);
	}

	public Map<String, Player> getPlayersConcurrent(List<Member> members) {
		List<APIPlayerTask> tasks = new ArrayList<APIPlayerTask>();
		String token = properties.getToken();
		for (Member member : members) {
			String url = properties.getPlayerurl().replaceAll("\\{parm\\}", member.getTag().substring(1));
			tasks.add(new APIPlayerTask(url, token));
		}

		List<Future<String>> features;
		Map<String, Player> players = new HashMap<String, Player>(64);
		try {
			features = exec.invokeAll(tasks);
			for (Future<String> feature : features) {
				JSONObject jSONobj = JSONObject.fromObject(feature.get());
				Player player = new Player();
				player.setTag(jSONobj.getString("tag"));
				player.setWarstar(Integer.parseInt(jSONobj.getString("warStars")));
				players.put(player.getTag(), player);
			}

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new HashMap<String, Player>(players);
	}
}