package org.unitedpro.mumsched.domain;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
	@Column(name = "firstname")
	private String firstName;
	@NotEmpty
	@Column(name = "lastname")
	private String lastName;
	//@NotEmpty
	@Column(name = "DOB")
	private LocalDate DOB;
	@NotEmpty
	@Email
	@Column(name = "email")
	private String email;
	

	
	@OneToMany(mappedBy = "student")
	private Set<Student_Section> student_Sections = new HashSet<Student_Section>(0);	
	
	public Set<Student_Section> getSections() {
		return this.student_Sections;
	}

	public long getStudent_id() {
		return student_id;
	}

	public void setStudent_id(long student_id) {
		this.student_id = student_id;
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

	public LocalDate getDOB() {
		return DOB;
	}

	public void setDOB(LocalDate dOB) {
		DOB = dOB;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Student_Section> getStudent_Sections() {
		return student_Sections;
	}

	public void setStudent_Sections(Set<Student_Section> student_Sections) {
		this.student_Sections = student_Sections;
	}
	
}
