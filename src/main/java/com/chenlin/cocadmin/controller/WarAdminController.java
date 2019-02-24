package com.chenlin.cocadmin.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chenlin.cocadmin.entities.ClanWarApp;
import com.chenlin.cocadmin.entities.War;
import com.chenlin.cocadmin.entities.Warmember;
import com.chenlin.cocadmin.service.IClanWarApplyService;
import com.chenlin.cocadmin.service.IMemberService;
import com.chenlin.cocadmin.service.IWarService;

@Controller
@RequestMapping("/clanwar")
public class WarAdminController {

	@Autowired
	private IClanWarApplyService warAppservice;

	@Autowired
	private IMemberService memberService;

	@Autowired
	private IWarService warService;

	@RequestMapping(value = "/applylist", method = RequestMethod.GET)
	public String memberlist(Model model) throws IOException {
		War activeWar = warService.searchActiveWar();
		List<ClanWarApp> warApps = warAppservice.showListByWarId(activeWar.getId());
		model.addAttribute("warmember", warApps);
		return "waradmin";
	}

	@RequestMapping(value = "/apply", method = RequestMethod.POST)
	public String warEnrollsubmit(@Valid Warmember warmember, Errors errors, Model model)
			throws SQLException, ParseException {

		if (errors.hasErrors()) {
			// List<Warmember> members=service.showMember();
			// model.addAttribute("warmember", members);
			return "errors";
		}

		ClanWarApp clanWarApp = new ClanWarApp();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse(warmember.getDate());
		clanWarApp.setBeginDate(date);
		clanWarApp.setMemberId(memberService.searchMemberByTag(warmember.getTag()).getId());
		clanWarApp.setWarId(warService.searchActiveWar().getId());
		warAppservice.apply(clanWarApp);
		return "redirect:/clanwar/applylist";

	}

}
