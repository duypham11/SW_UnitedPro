package org.unitedpro.mumsched.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "Section")
public class Section {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long section_id;
	@NotEmpty
	@Column(name = "SectionName")
	private String sectionName;
	
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id")
    private Course course;

    @OneToMany
    private List<Faculty> facultys;

	@OneToMany(mappedBy = "section")
	private Set<Student_Section> student_Sections = new HashSet<Student_Section>(0);	
	
	public Set<Student_Section> getStudents() {
		return this.student_Sections;
	}

    @ManyToOne
    private Block block;

    @Column(name = "room_no")
    private String roomNo;

    @Column(name = "available_seat")
    private int availableSeats = 25; 
}
