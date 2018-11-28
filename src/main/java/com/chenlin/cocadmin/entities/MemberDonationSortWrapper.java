package com.chenlin.cocadmin.entities;

public class MemberDonationSortWrapper extends Member implements Comparable<Member>{
	
	private int pk;
	private String tag;
	private String name;
	private String position;
	private int donations;		
	private int donationsReceived;
	private int warstar;
	
	public MemberDonationSortWrapper(Member member){
		this.tag = member.getTag();
		this.name = member.getName();
		this.position=member.getPosition();
		this.donations = member.getDonations();
		this.donationsReceived = member.getDonationsreceived();
		this.warstar=member.getWarstar();
	}
	
	@Override
	public int compareTo(Member member) {
		// TODO Auto-generated method stub
		int num=member.getDonations()-this.getDonations();
		if(this.getDonations() < member.getDonations()){
			return 1;
		}else if(this.donations > member.getDonations()){
			return -1;
		}
		return num==0 ? this.tag.compareTo(member.getTag()) : num;
	}

	public int getPk() {
		return pk;
	}

	public void setPk(int pk) {
		this.pk = pk;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Integer getDonations() {
		return donations;
	}

	public void setDonations(int donations) {
		this.donations = donations;
	}

	public int getDonationsReceived() {
		return donationsReceived;
	}

	public void setDonationsReceived(int donationsReceived) {
		this.donationsReceived = donationsReceived;
	}
	
	public void setWarstar(int warstar) {
		this.warstar = warstar;
	}
	public Integer getWarstar() {
		return warstar;
	}
	
	

}
