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
}
