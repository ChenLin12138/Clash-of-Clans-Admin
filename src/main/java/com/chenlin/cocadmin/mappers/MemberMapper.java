package com.chenlin.cocadmin.mappers;

import org.apache.ibatis.annotations.Mapper;

import com.chenlin.cocadmin.entities.Member;

@Mapper
public interface MemberMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Member record);

    int insertSelective(Member record);

    Member selectByPrimaryKey(Integer id);
    
    Member selectByTag(String tag);

    int updateByPrimaryKeySelective(Member record);

    int updateByPrimaryKey(Member record);
    
    
}