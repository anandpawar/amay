package com.vc.model;

import com.sun.jmx.snmp.Timestamp;

public class AskQuestion {
	private long id;
	private String upLoadedBy;
	private String Title;
	private String content;
	private String subject;
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
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public Timestamp getUpLoadtime() {
		return upLoadtime;
	}
	public void setUpLoadtime(Timestamp upLoadtime) {
		this.upLoadtime = upLoadtime;
	}

}
