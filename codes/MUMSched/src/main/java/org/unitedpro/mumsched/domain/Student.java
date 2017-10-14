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
	

	
	@OneToMany(mappedBy = "student")
	private Set<Student_Section> student_Sections = new HashSet<Student_Section>(0);	
	
	public Set<Student_Section> getSections() {
		return this.student_Sections;
	}
}
