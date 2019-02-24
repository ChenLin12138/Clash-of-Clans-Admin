package com.chenlin.cocadmin.serviceImpl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chenlin.cocadmin.entities.Clandetails;
import com.chenlin.cocadmin.entities.Member;
import com.chenlin.cocadmin.entities.api.APIProperties;
import com.chenlin.cocadmin.parser.ClanParser;
import com.chenlin.cocadmin.parser.MemberParser;

@Service
public class ClanAPIService extends BaseAPIService {

	@Autowired
	private APIProperties properties;

	public List<Member> getMembers(String clanTag) throws IOException {
		String rowData = fetchRowData(properties.getMembersurl().replaceAll("\\{parm\\}", clanTag),
				properties.getToken());
		MemberParser memberParser = new MemberParser();
		return memberParser.getMembers(rowData);
	}

	public List<Clandetails> getClan(String clanTag) throws IOException {
		String rowData = fetchRowData(properties.getMembersurl().replaceAll("\\{parm}\\", clanTag),
				properties.getToken());
		ClanParser clanParse = new ClanParser();
		return clanParse.getClans(rowData);
	}
}
