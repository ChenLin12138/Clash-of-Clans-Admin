package com.chenlin.cocadmin.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chenlin.cocadmin.entities.Member;
import com.chenlin.cocadmin.mappers.MemberMapper;
import com.chenlin.cocadmin.service.IMemberService;

@Service
public class MemberServiceImpl implements IMemberService {

	@Autowired
	private MemberMapper mapper;

	@Override
	public Member searchMemberByTag(String tag) {

		return mapper.selectByTag(tag);
	}

}
