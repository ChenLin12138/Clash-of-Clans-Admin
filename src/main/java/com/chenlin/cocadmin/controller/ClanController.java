package com.chenlin.cocadmin.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chenlin.cocadmin.entities.Clandetails;
import com.chenlin.cocadmin.entities.Member;
import com.chenlin.cocadmin.entities.MemberDonationSortWrapper;
import com.chenlin.cocadmin.entities.Warmember;
import com.chenlin.cocadmin.entities.api.APIProperties;
import com.chenlin.cocadmin.parser.MemberParser;
import com.chenlin.cocadmin.serviceImpl.APIService;

@Controller
@RequestMapping("/clan")

public class ClanController {

	@Autowired
	private APIService service;

	@Autowired
	private APIProperties properties;

	@RequestMapping(value = "/members", method = RequestMethod.GET)
	public String getMembers(Model model) throws IOException {
		Collection<Member> members = service.getMembers(properties.getUrl(), properties.getToken());

		Set<MemberDonationSortWrapper> set = new TreeSet<MemberDonationSortWrapper>();

		for (Member member : members) {
			MemberDonationSortWrapper memberDonationSortWrapper = new MemberDonationSortWrapper(member);
			set.add(memberDonationSortWrapper);
		}
		// int size=members.size();
		model.addAttribute("members", set);
		// int a=set.size();

		return "members";
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String clanHome() {
		return "clan";
	}

	@RequestMapping(value = "/details", method = RequestMethod.GET)
	public String getClans(Model model) throws IOException {
		List<Clandetails> clans = service.getClans(properties.getClanurl(), properties.getToken());
		Clandetails clan = clans.get(0);
		model.addAttribute("clandetails", clan);

		return "clandetails";
	}
	@RequestMapping(value = "/wardetails", method = RequestMethod.GET)
	public String getWar(Model model) throws IOException {
		List<Clandetails> clans = service.getClans(properties.getClanurl(), properties.getToken());
		Clandetails clan = clans.get(0);
		model.addAttribute("wardetails", clan);

		return "wardetails";
	}
}
