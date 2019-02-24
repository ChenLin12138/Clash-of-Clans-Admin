package com.chenlin.cocadmin.service;

import java.util.List;

import com.chenlin.cocadmin.entities.ClanWarApp;

public interface IClanWarApplyService {

	public void apply(ClanWarApp clanWar);

	public void cancel(ClanWarApp clanWar);

	public List<ClanWarApp> showListByWarId(int warId);

	public ClanWarApp getLastWar();

}
