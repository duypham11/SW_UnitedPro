package org.unitedpro.mumsched.domain;

import java.time.LocalDate;

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
	@Column(name = "firstName")
	private String firstName;
	@NotEmpty
	@Column(name = "lastName")
	private String lastName;
	@NotEmpty
	@Column(name = "DOB")
	private LocalDate DOB;
	@NotEmpty
	@Email
	@Column(name = "email")
	private String email;
}
