package org.unitedpro.mumsched.domain;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "Student")
public class Student {
	

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "student_id")
	private long student_id;
	
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
	

	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Student_Section", joinColumns = { @JoinColumn(name = "student_id") }, inverseJoinColumns = { @JoinColumn(name = "section_id") })
	private Set<Section> section = new HashSet<Section>(0);	
	
	public Set<Section> getSection() {
		return this.section;
	}
}
