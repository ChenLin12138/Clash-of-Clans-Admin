package com.chenlin.cocadmin.entities;

public class War {
	
	public static final Integer STATUS_ACTIVE = 1;
	public static final Integer STATUS_FINISH = 2;
	
    private Integer id;

    private Byte status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}