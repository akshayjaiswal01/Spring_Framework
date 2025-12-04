package com.demo.beans;

public class Skill 
{
	 private int sid;
	 private String sname;
	 private String exp;
	public Skill() {
		super();
	}
	public Skill(int sid, String sname, String exp) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.exp = exp;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getExp() {
		return exp;
	}
	public void setExp(String exp) {
		this.exp = exp;
	}
	@Override
	public String toString() {
		return "Skill [sid=" + sid + ", sname=" + sname + ", exp=" + exp + "]";
	}
	 
	 
	
}
