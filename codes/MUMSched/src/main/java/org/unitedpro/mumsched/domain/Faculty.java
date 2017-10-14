package org.unitedpro.mumsched.domain;

import java.time.LocalDate;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "Faculty")
public class Faculty {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long faculty_id;
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
	@NotEmpty
    private String password;

    @ManyToMany(cascade = CascadeType.ALL)
    private Collection<Course> courses;
}