package com.vc.model;

import com.sun.jmx.snmp.Timestamp;

public class Replay {

	private long id;
	private String replyBy;
	private String content;
	private long replyon;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getReplyBy() {
		return replyBy;
	}
	public void setReplyBy(String replyBy) {
		this.replyBy = replyBy;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public long getReplyon() {
		return replyon;
	}
	public void setReplyon(long replyon) {
		this.replyon = replyon;
	}

}
