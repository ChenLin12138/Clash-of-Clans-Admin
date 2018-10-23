package com.chenlin.cocadmin.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chenlin.cocadmin.entities.ClanWarApp;
import com.chenlin.cocadmin.entities.Member;
import com.chenlin.cocadmin.mappers.IClanWarAppMapper;
import com.chenlin.cocadmin.service.IClanWarApplyService;

@Service
public class ClanWarApplyServiceImpl implements IClanWarApplyService{

	@Autowired
	private IClanWarAppMapper mapper;
	
	@Override
	public void apply(Member member, ClanWarApp clanWar) {
		ClanWarApp cwp = new ClanWarApp(member.getTag(), clanWar.getId(), clanWar.getBeginDate());		
		mapper.insert(cwp);	
	}

	@Override
	public void cancel(Member member, ClanWarApp clanWar) {
	}

	@Override
	public List<ClanWarApp> showListByWarId(int warId) {
		List<ClanWarApp> memberList = mapper.selectByWarId(warId);
		return memberList;
	}

	@Override
	public ClanWarApp getLastWar() {		
		return mapper.selectLstWar();
	}


}
