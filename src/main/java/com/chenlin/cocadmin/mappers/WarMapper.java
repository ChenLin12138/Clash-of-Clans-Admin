package com.chenlin.cocadmin.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.chenlin.cocadmin.entities.War;

@Mapper
public interface WarMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(War record);

	int insertSelective(War record);

	War selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(War record);

	int updateByPrimaryKey(War record);

	List<War> selectByStatus(Integer status);

}