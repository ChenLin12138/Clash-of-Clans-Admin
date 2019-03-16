package com.chenlin.cocadmin.mappers.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.chenlin.cocadmin.config.DataSrouceConfig;
import com.chenlin.cocadmin.config.MybatisMapperConfig;
import com.chenlin.cocadmin.entities.Member;
import com.chenlin.cocadmin.mappers.MemberMapper;

/**
* @author Chen Lin
* @Date Create Mar 14, 2019 2:16:05 PM
*/


@RunWith(SpringRunner.class) 
@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ContextConfiguration(classes={DataSrouceConfig.class,MybatisMapperConfig.class})

public class MemberMapperTest {
	
	@Autowired
	MemberMapper mapper;
	
	
	@Test
	public void shouldReturnAMemberWhenpkis1(){
		//given
				
		//when
		Member member = mapper.selectByPrimaryKey(1);
		
		//then
		assertTrue("ABCDEFG".equals(member.getTag()));
		assertTrue("name".equals(member.getName()));
		assertEquals(new Integer(11),member.getDonations());
		assertEquals(new Integer(111),member.getDonationsreceived());
		
	}
	
}
