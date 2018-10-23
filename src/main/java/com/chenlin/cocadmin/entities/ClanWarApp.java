package com.chenlin.cocadmin.entities;

import java.util.Date;

public class ClanWarApp {
    private Integer id;

    private Integer warId;

    private String memberTag;

    private Date beginDate;

    public ClanWarApp(String memberTag, Integer warId, Date beginDate) {
    	this.memberTag = memberTag;
    	this.warId = warId;
    	this.beginDate = beginDate;
    }

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getWarId() {
        return warId;
    }

    public void setWarId(Integer warId) {
        this.warId = warId;
    }

    public String getMemberTag() {
        return memberTag;
    }

    public void setMemberTag(String memberTag) {
        this.memberTag = memberTag == null ? null : memberTag.trim();
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }
}