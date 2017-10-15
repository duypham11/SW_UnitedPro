package org.unitedpro.mumsched.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "Course")
public class Course {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long course_id;
	
	@NotEmpty
    @Column(unique = true, name = "course_code")
    private String courseCode;
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "Pre_Courses",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "pre_course_id")
    )
    private List<Course> preCourses;
    
	@NotEmpty
	@Column(name = "courseName")
	private String courseName;
	
	@NotEmpty
    @Column(name = "course_description")
    private String courseDescription;

	public long getCourse_id() {
		return course_id;
	}

	public void setCourse_id(long course_id) {
		this.course_id = course_id;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public List<Course> getPreCourses() {
		return preCourses;
	}

	public void setPreCourses(List<Course> preCourses) {
		this.preCourses = preCourses;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseDescription() {
		return courseDescription;
	}

	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}
	
}
