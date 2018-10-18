package com.admin.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.admin.entities.ClanWar;
import com.admin.entities.ClanWarApp;
import com.admin.entities.Member;


public interface IClanWarApplyService {
	
	public void apply(Member member, ClanWar clanWar);
	
	public void cancel(Member member, ClanWar clanWar);
	
	public List<ClanWarApp> showListByWarId(int warId);
	
	public int getLastWarId();
	
}
