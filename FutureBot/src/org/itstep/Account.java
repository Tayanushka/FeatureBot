package org.itstep;

public class Account {

	private String email;
	private String pass;
	private String fullName;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	public Account(String email, String pass, String fullName) {
		super();
		this.email = email;
		this.pass = pass;
		this.fullName = fullName;
	}
	
	public Account(Account acc) {
		super();
		this.email = acc.getEmail();
		this.pass = acc.getPass();
		this.fullName = acc.getFullName();
	}
	
	public Account() {

	}
	
}
