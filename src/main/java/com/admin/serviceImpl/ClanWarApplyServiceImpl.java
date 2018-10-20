package com.admin.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.admin.entities.ClanWarApp;
import com.admin.entities.Member;
import com.admin.mappers.IClanWarAppMapperBackup;
import com.admin.service.IClanWarApplyService;

@Service
public class ClanWarApplyServiceImpl implements IClanWarApplyService{

	@Autowired
	private IClanWarAppMapperBackup mapper;
	
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
	public int getLastWarId() {		
		return mapper.selectLstWarId();
	}
	
	

}
