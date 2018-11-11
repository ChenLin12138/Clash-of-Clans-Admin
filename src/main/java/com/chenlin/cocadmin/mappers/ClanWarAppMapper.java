package com.chenlin.cocadmin.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.chenlin.cocadmin.entities.ClanWarApp;

@Mapper
public interface ClanWarAppMapper {
	
    int deleteByPrimaryKey(Integer id);

    int insert(ClanWarApp record);

    int insertSelective(ClanWarApp record);

    ClanWarApp selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ClanWarApp record);

    int updateByPrimaryKey(ClanWarApp record);
    
    ClanWarApp selectLstWar();
    
    List<ClanWarApp> selectByWarId(int war_id);
    
}