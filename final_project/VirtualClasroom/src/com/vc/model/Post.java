package com.vc.model;

import com.sun.jmx.snmp.Timestamp;

public class Post {
	private long id;
	private String upLoadedBy;
	private String postcontent;
	private Timestamp  upLoadtime;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUpLoadedBy() {
		return upLoadedBy;
	}
	public void setUpLoadedBy(String upLoadedBy) {
		this.upLoadedBy = upLoadedBy;
	}
	public String getPostcontent() {
		return postcontent;
	}
	public void setPostcontent(String postcontent) {
		this.postcontent = postcontent;
	}
	public Timestamp getUpLoadtime() {
		return upLoadtime;
	}
	public void setUpLoadtime(Timestamp upLoadtime) {
		this.upLoadtime = upLoadtime;
	}
	

	
}



