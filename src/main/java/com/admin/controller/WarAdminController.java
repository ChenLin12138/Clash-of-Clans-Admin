package com.admin.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.admin.entities.ClanWarApp;
import com.admin.entities.Member;
import com.admin.entities.Warmember;
import com.admin.service.IClanWarApplyService;


@Controller
@RequestMapping("/clanwar")
public class WarAdminController {

	@Autowired
	private IClanWarApplyService service;
	
	@RequestMapping(value = "/applylist", method = RequestMethod.GET)
	public String memberlist(Model model) throws IOException {
		List<ClanWarApp> members = service.showListByWarId(service.getLastWarId());
		model.addAttribute("warmember", members);
		return "waradmin";
	}
	
}
