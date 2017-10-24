package org.unitedpro.mumsched.domain;

import java.util.List;

public class User {
	private String email;
	private String password;
	private List<Role> roleList;

	public User(String email, String password, List<Role> roleList) {
		this.email = email;
		this.password = password;
		this.roleList = roleList;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

}
