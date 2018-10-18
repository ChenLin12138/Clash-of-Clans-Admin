package com.admin.entities;

public class ClanWarApp {
	
	private int id;
	
	private int warId;
	
	private String memberTag;
	
	private String beginDate;
	
	public ClanWarApp(){
		
	}
	
	public ClanWarApp(String memberId, int warId, String beginDate){
		this.warId = warId;
		this.memberTag = memberId;
		this.beginDate = beginDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getWarId() {
		return warId;
	}

	public void setWarId(int warId) {
		this.warId = warId;
	}

	public String getMemberTag() {
		return memberTag;
	}

	public void setMemberTag(String memberTag) {
		this.memberTag = memberTag;
	}

	public String getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}


}
