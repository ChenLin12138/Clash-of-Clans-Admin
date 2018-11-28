package com.chenlin.cocadmin.entities;

public class Member {
    private Integer id;

    private String tag;

    private String name;

    private String position;

    private Integer donations;

    private Integer donationsreceived;
    private Integer warstar;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag == null ? null : tag.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    public Integer getDonations() {
        return donations;
    }

    public void setDonations(Integer donations) {
        this.donations = donations;
    }

    public Integer getDonationsreceived() {
        return donationsreceived;
    }
    

    public void setDonationsreceived(Integer donationsreceived) {
        this.donationsreceived = donationsreceived;
    }

	public Integer getWarstar() {
		return warstar;
	}

	public void setWarstar(Integer warstar) {
		this.warstar = warstar;
	}
}