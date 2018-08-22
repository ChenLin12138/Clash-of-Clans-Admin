package com.admin.controller;

import java.io.IOException;
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

import com.admin.entity.APIProperties;
import com.admin.model.Clandetails;
import com.admin.model.Member;
import com.admin.model.MemberDonationSortWrapper;
import com.admin.model.Warmember;
import com.admin.service.APIService;

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
	/*@RequestMapping(value = "/currentwar", method = RequestMethod.GET)
	public String getCurrentWar(Model model) throws IOException {
		List<Clandetails> clans = service.getCurrentWar(properties.getCurrentwar(), properties.getToken());
		Clandetails clan = clans.get(0);
		model.addAttribute("clandetails", clan);

		return "clandetails";
	}*/
	@RequestMapping(value = "/waradmin", method = RequestMethod.GET)
	public String warEnroll(Model model) throws IOException {
		List<Warmember> members=service.showMember();
		model.addAttribute("warmember", members);
		return "waradmin";
	}
	@RequestMapping(value = "/waradmin", method = RequestMethod.POST)
	public String warEnrollsubmit(@Valid Warmember warmember,Errors errors,Model model) throws IOException {
		
		if (errors.hasErrors()) {
			List<Warmember> members=service.showMember();
			model.addAttribute("warmember", members);
			return "waradmin";
		}
		service.save(warmember);
		List<Warmember> members=service.showMember();
		model.addAttribute("warmember", members);
		return "waradmin";
	}
	

}
