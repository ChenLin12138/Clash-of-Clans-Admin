package com.chenlin.cocadmin.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
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
		List<Member> members = service.getMembers(clanTag);	
		Set<MemberDonationSortWrapper> set = new TreeSet<MemberDonationSortWrapper>();
		
		long timeStart = System.currentTimeMillis();
		Map<String,Player> players = playerservice.getPlayersConcurrent(members);
		
//		Map<String,Player> players = playerservice.getPlayersSerial(members);
		
		long timeEnd = System.currentTimeMillis();
		System.out.println(timeEnd-timeStart);
//comment for remove player war start		
		for(Member member : members){ 
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
