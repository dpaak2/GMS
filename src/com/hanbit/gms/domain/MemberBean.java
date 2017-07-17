package com.hanbit.gms.domain;

import java.io.Serializable;

public class MemberBean implements Serializable{
	private String id, pw, ssn,name,regedate;

	public String getRegedate() {
		return regedate;
	}

	public void setRegedate(String regedate) {
		this.regedate = regedate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "MemberBean [id=" + id + ", pw=" + pw + ", ssn=" + ssn + ", name=" + name + ", regedate=" + regedate
				+ "] \n";
	}
	
}
