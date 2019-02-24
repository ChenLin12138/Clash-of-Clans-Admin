package com.chenlin.cocadmin.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chenlin.cocadmin.entities.ClanWarApp;
import com.chenlin.cocadmin.mappers.ClanWarAppMapper;
import com.chenlin.cocadmin.service.IClanWarApplyService;

@Service
public class ClanWarApplyServiceImpl implements IClanWarApplyService {

	@Autowired
	private ClanWarAppMapper mapper;

	@Override
	public void apply(ClanWarApp clanWar) {
		clanWar.setStatus(ClanWarApp.STATUS_ACTIVE);
		mapper.insert(clanWar);
	}

	@Override
	public void cancel(ClanWarApp clanWar) {
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
