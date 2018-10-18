package com.admin.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.admin.entities.ClanWarApp;

@Mapper
public interface IClanWarAppMapper {
	
	@Insert("insert into clanwarapp(war_id, member_tag) values(#{warId},#{memberTag},#{beginDate})")
	@Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
	void insert(ClanWarApp ca);
	
	@Update("update clanwarapp set member_tag=#{memberTag}")
	int update(ClanWarApp ca);
	
	@Delete("delete from clanwarapp where id=#{id}")
	int delete(@Param("id") int id);
	
	@Select("select id, war_id, member_tag, begin_date from clanwarapp where war_id=#{warId}")
	List<ClanWarApp> selectByWarId(@Param("warId") int war_id);
	
	@Select("select id, war_id, member_tag, begin_date from clanwarapp where id=#{id}")
	ClanWarApp selectById(@Param("id") int id);
	
	@Select("select war_id from clanwarapp order by war_id desc limit 1 ")
	int selectLstWarId();
	
	

}
