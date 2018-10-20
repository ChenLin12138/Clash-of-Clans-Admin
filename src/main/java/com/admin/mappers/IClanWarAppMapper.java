package com.admin.mappers;

import com.admin.entities.ClanWarApp;

public interface IClanWarAppMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ClanWarApp record);

    int insertSelective(ClanWarApp record);

    ClanWarApp selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ClanWarApp record);

    int updateByPrimaryKey(ClanWarApp record);
}