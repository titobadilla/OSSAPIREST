package com.tvoseguridadelectronica.oss.domain;


public class ChangePassword {
	
	private String passwordPrevious;
	private String passwordNew;
	private String idEmployee;
	
	public ChangePassword(String passwordPrevious, String passwordNew, String idEmployee) {
		this.passwordPrevious = passwordPrevious;
		this.passwordNew = passwordNew;
		this.idEmployee = idEmployee;
	}

	public ChangePassword() {
		
	}

	public String getPasswordPrevious() {
		return passwordPrevious;
	}

	public void setPasswordPrevious(String passwordPrevious) {
		this.passwordPrevious = passwordPrevious;
	}

	public String getPasswordNew() {
		return passwordNew;
	}

	public void setPasswordNew(String passwordNew) {
		this.passwordNew = passwordNew;
	}

	public String getIdEmployee() {
		return idEmployee;
	}

	public void setIdEmployee(String idEmployee) {
		this.idEmployee = idEmployee;
	}

	@Override
	public String toString() {
		return "ChangePassword [passwordPrevious=" + passwordPrevious + ", passwordNew=" + passwordNew + ", idEmployee="
				+ idEmployee + "]";
	}
	
	

}
