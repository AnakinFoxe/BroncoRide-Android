package com.BroncoRide.Entity;

public class Code {

	private int codeID;
	private String email;
	private int code;

	public Code() {

	}

	public Code(int codeID, String email, int code) {
		this.codeID = codeID;
		this.email = email;
		this.code = code;
	}

	public int getCodeID() {
		return codeID;
	}

	public void setCodeID(int codeID) {
		codeID = codeID;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

}
