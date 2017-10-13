package org.unitedpro.mumsched.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    
	@NotEmpty
	@Column(name = "CourseName")
	private String courseName;
	
	@NotEmpty
    @Column(name = "course_description")
    private String courseDescription;
}
