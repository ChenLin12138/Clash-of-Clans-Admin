package com.chenlin.cocadmin.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.chenlin.cocadmin.entities.ClanWarApp;
import com.chenlin.cocadmin.entities.Member;


public interface IClanWarApplyService {
	
	public void apply(Member member, ClanWarApp clanWar);
	
	public void cancel(Member member, ClanWarApp clanWar);
	
	public List<ClanWarApp> showListByWarId(int warId);
	
	public ClanWarApp getLastWar();
	
}
