package com.chenlin.cocadmin.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chenlin.cocadmin.entities.Clandetails;
import com.chenlin.cocadmin.entities.Member;
import com.chenlin.cocadmin.entities.MemberDonationSortWrapper;
import com.chenlin.cocadmin.entities.Player;
import com.chenlin.cocadmin.serviceImpl.ClanAPIService;
import com.chenlin.cocadmin.serviceImpl.PlayerService;
import com.chenlin.cocadmin.task.APIPlayerTask;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/clan")

public class ClanController {

	@Autowired
	private ClanAPIService service;
	@Autowired
	private PlayerService playerservice;


	@RequestMapping(value = "/members", method = RequestMethod.GET)
	public String getMembers(Model model) throws IOException {
		String clanTag = "92JGQUR";
		Collection<Member> members = service.getMembers(clanTag);	
		Set<MemberDonationSortWrapper> set = new TreeSet<MemberDonationSortWrapper>();
		
		
		long timeStart = System.currentTimeMillis();

		List<APIPlayerTask> tasks = new ArrayList<APIPlayerTask>();
		
		for(Member member : members){ 
			tasks.add(new APIPlayerTask(member.getTag().substring(1)));
		}
		
		ExecutorService exec = Executors.newFixedThreadPool(20);
		List<Future<String>> features;
		Map<String,Player> players = new HashMap<String, Player>(64);
		
		try {
			features = exec.invokeAll(tasks);
//			players = new ArrayList<String>(tasks.size());
			for(Future<String> feature : features) {
				JSONObject jSONobj = JSONObject.fromObject(feature.get());
				Player player=new Player();
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
				
		long timeEnd = System.currentTimeMillis();
		System.out.println(timeEnd-timeStart);
		for(Member member : members){ 
//			JSONObject jSONobj = JSONObject.fromObject(rowData);
//			Player player=new Player();
//			player.setWarstar(Integer.parseInt(jSONobj.getString("warStars")));
//			Player player=playerservice.getPlayer(member);
//			member.setWarstar(player.getWarstar());
			Player player = players.get(member.getTag());
			member.setWarstar(player.getWarstar());
			MemberDonationSortWrapper memberDonationSortWrapper = new MemberDonationSortWrapper(member);
			set.add(memberDonationSortWrapper);
		}

		model.addAttribute("members", set);

		return "members";
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String clanHome() {
		return "clan";
	}

	@RequestMapping(value = "/details", method = RequestMethod.GET)
	public String getClans(Model model) throws IOException {
		String clanTag = "92JGQUR";
		List<Clandetails> clans = service.getClan(clanTag);
		Clandetails clan = clans.get(0);
		model.addAttribute("clandetails", clan);

		return "clandetails";
	}
	@RequestMapping(value = "/wardetails", method = RequestMethod.GET)
	public String getWar(Model model) throws IOException {
		String clanTag = "92JGQUR";
		List<Clandetails> clans = service.getClan(clanTag);
		Clandetails clan = clans.get(0);
		model.addAttribute("wardetails", clan);

		return "wardetails";
	}
}
