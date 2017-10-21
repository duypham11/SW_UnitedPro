package org.unitedpro.mumsched.domain;

import java.util.List;

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
@Table(name = "Faculty")
public class Faculty {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long faculty_id;
	@NotEmpty
	@Column
	private String firstName;
	@NotEmpty
	@Column
	private String lastName;
	@NotEmpty
	@Column
	private String DOB;
	@NotEmpty
	@Email
	@Column
	private String email;
	@NotEmpty
	@Column
    private String password;

//    @ManyToMany(cascade = CascadeType.ALL)
//    private Collection<Course> courses;

	@ManyToMany
	@JoinTable(
			name="Faculty_Course",
			joinColumns=@JoinColumn(name="faculty_Id", referencedColumnName="faculty_id"),
			inverseJoinColumns=@JoinColumn(name="course_id", referencedColumnName="course_id"))
	private List<Course> courseList;

	public long getFaculty_id() {
		return faculty_id;
	}

	public void setFaculty_id(long faculty_id) {
		this.faculty_id = faculty_id;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Course> getCourses() {
		return courseList;
	}

	public void setCourses(List<Course> coursesList) {
		this.courseList = coursesList;
	}
    
}
