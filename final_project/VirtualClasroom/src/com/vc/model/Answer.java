package com.vc.model;

import com.sun.jmx.snmp.Timestamp;

public class Answer {
	private long answer_id;
	private String answer_by;
	private String answer_content;
	private long answer_on;
	public long getAnswer_id() {
		return answer_id;
	}
	public void setAnswer_id(long answer_id) {
		this.answer_id = answer_id;
	}
	public String getAnswer_by() {
		return answer_by;
	}
	public void setAnswer_by(String answer_by) {
		this.answer_by = answer_by;
	}
	public String getAnswer_content() {
		return answer_content;
	}
	public void setAnswer_content(String answer_content) {
		this.answer_content = answer_content;
	}
	public long getAnswer_on() {
		return answer_on;
	}
	public void setAnswer_on(long answer_on) {
		this.answer_on = answer_on;
	}
	
	
}
