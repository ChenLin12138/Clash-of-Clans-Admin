package com.admin.entities;

public class ClanWar {
	
	private int id;
	
	private int war_id;
	
	private int result;
	
	private String score;
	
	private String beginDate;
		

	public String getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getWar_id() {
		return war_id;
	}

	public void setWar_id(int war_id) {
		this.war_id = war_id;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}
	
	
}
