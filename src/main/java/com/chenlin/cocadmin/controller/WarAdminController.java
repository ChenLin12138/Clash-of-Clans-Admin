package com.chenlin.cocadmin.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chenlin.cocadmin.entities.ClanWarApp;
import com.chenlin.cocadmin.entities.Member;
import com.chenlin.cocadmin.entities.Warmember;
import com.chenlin.cocadmin.service.IClanWarApplyService;


@Controller
@RequestMapping("/clanwar")
public class WarAdminController {

	@Autowired
	private IClanWarApplyService service;
	
	@RequestMapping(value = "/applylist", method = RequestMethod.GET)
	public String memberlist(Model model) throws IOException {
		List<ClanWarApp> members = service.showListByWarId(service.getLastWar().getWarId());
		model.addAttribute("warmember", members);
		return "waradmin";
	}
	
}
