package org.unitedpro.mumsched.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("serial")
@Entity
@Table(name="Student_Section")
public class Student_Section implements Serializable {

	public long getSs_id() {
		return ss_id;
	}

	public void setSs_id(long ss_id) {
		this.ss_id = ss_id;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long ss_id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn  
    private Student student;
    public Student getStudent() {
        return student;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn  
    private Section section;
    public Section getSection() {
        return section;
    }

    @Column
    private char grade;

    @Column
    private Double point;
    
    public Double getPoint() {
		return point;
	}
	public void setPoint(Double point) {
		this.point = point;
	}
	
    @Column
    private boolean isApproved;

    @Column
    private String comments;
    
    
	public char getGrade() {
		return grade;
	}
	public void setGrade(char grade) {
		this.grade = grade;
	}
	public boolean isApproved() {
		return isApproved;
	}
	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public void setSection(Section section) {
		this.section = section;
	}
    
}
