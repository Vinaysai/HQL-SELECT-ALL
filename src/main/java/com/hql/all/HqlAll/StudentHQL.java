package com.hql.all.HqlAll;

public class StudentHQL {

	private int id;
	private String fname;
	private String lname;
	private String email;

	public StudentHQL() {
		super();
	}

	public String getEmail() {
		return email;
	}

	public String getFname() {
		return fname;
	}

	public int getId() {
		return id;
	}

	public String getLname() {
		return lname;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	@Override
	public String toString() {
		return "StudentHQL [id=" + id + ", fname=" + fname + ", lname=" + lname + ", email=" + email + "]";
	}

}
