package com.chenlin.cocadmin.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.chenlin.cocadmin.mappers.MemberMapper;

/**
 * @author Chen Lin
 * @Date Create Mar 15, 2019 5:37:04 PM
 */

@Configuration
public class MybatisMapperConfig {

	@Autowired
	BasicDataSource dataSource;

	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
		sqlSessionFactory.setDataSource(dataSource);
		return (SqlSessionFactory) sqlSessionFactory.getObject();
	}

	@Bean
	public SqlSessionTemplate sqlSessionTemplate() throws Exception {
		SqlSessionTemplate sessionTemplate = new SqlSessionTemplate(sqlSessionFactory());
		sessionTemplate.getConfiguration().addMappers("com.chenlin.cocadmin.mappers");
		return sessionTemplate;
	}

	@Bean
	public MemberMapper memberMapper() throws Exception {

		return sqlSessionTemplate().getMapper(MemberMapper.class);

	}

}
