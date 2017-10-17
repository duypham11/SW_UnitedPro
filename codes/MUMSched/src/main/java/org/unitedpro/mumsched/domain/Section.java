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
	@Column
	private String sectionName;
	
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn
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

    @Column
    private String roomNo;

    @Column
    private int availableSeats = 25;

	public long getSection_id() {
		return section_id;
	}

	public void setSection_id(long section_id) {
		this.section_id = section_id;
	}

	public String getSectionName() {
		return sectionName;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public List<Faculty> getFacultys() {
		return facultys;
	}

	public void setFacultys(List<Faculty> facultys) {
		this.facultys = facultys;
	}

	public Set<Student_Section> getStudent_Sections() {
		return student_Sections;
	}

	public void setStudent_Sections(Set<Student_Section> student_Sections) {
		this.student_Sections = student_Sections;
	}

	public Block getBlock() {
		return block;
	}

	public void setBlock(Block block) {
		this.block = block;
	}

	public String getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}

	public int getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	} 
    
    
}
