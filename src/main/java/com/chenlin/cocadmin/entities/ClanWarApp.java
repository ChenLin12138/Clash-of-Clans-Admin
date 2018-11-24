package com.chenlin.cocadmin.entities;

import java.util.Date;

public class ClanWarApp {
	
	public static final Integer STATUS_ACTIVE = 1;
	public static final Integer STATUS_CANCEL = 2;
	
    private Integer id;

    private Integer warId;

    private Integer memberId;

    private Date beginDate;
    
    private Member member;
    
    private Integer status;

    public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
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

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }
}