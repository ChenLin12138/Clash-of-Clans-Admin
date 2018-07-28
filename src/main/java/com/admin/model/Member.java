package com.admin.model;

public class Member{
	
	private int pk;
	private String tag;
	private String name;
	private int donations;
	private int donationsReceived;
	
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
	public int getDonations() {
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
	
}
