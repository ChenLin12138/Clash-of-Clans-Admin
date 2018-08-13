package com.admin.controller;

import java.io.IOException;
import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.admin.entity.APIProperties;
import com.admin.model.Member;
import com.admin.model.MemberDonationSortWrapper;
import com.admin.service.APIService;

@Controller
@RequestMapping("/clan")

public class ClanController {

	@Autowired
	private APIService service;
	
	@Autowired
	private APIProperties properties;
	
    @RequestMapping(value="/members", method = RequestMethod.GET)
    public String getMembers(Model model) throws IOException{	
    	Collection<Member> members = service.getMembers(properties.getUrl(), properties.getToken());	
    	
    	Set<MemberDonationSortWrapper> set = new TreeSet<MemberDonationSortWrapper>();
    	 	
    	for(Member member: members){
    		MemberDonationSortWrapper memberDonationSortWrapper = new MemberDonationSortWrapper(member);
    		set.add(memberDonationSortWrapper);		
    	}
    	model.addAttribute("members",set);
        return "members";
    }
	
}
