package org.unitedpro.mumsched.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "Admin")
public class Admin {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long admin_id;
	
	@NotEmpty
	@Column(name = "firstname")
	private String firstName;
	@NotEmpty
	@Column(name = "lastname")
	private String lastName;
	@NotEmpty
	@Column(name = "DOB")
	private String DOB;
	@NotEmpty
	@Email
	@Column(name = "email")	
	private String email;




	public long getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(long admin_id) {
		this.admin_id = admin_id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDOB() {
		return DOB;
	}
	public void setDOB(String dOB) {
		DOB = dOB;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	
}
