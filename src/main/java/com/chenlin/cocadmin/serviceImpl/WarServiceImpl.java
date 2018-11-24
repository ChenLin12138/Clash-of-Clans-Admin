package com.chenlin.cocadmin.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chenlin.cocadmin.entities.War;
import com.chenlin.cocadmin.mappers.WarMapper;
import com.chenlin.cocadmin.service.IWarService;

@Service
public class WarServiceImpl implements IWarService {

	@Autowired
	private WarMapper mapper;
	
	@Override
	public War searchActiveWar() {
		 List<War> warList = mapper.selectByStatus(War.STATUS_ACTIVE);
		 return warList.get(0);
	}

}
