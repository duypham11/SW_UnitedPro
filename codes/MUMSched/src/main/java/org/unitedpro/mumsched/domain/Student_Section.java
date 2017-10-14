package org.unitedpro.mumsched.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("serial")
@Entity
@Table(name="Student_Section")
public class Student_Section implements Serializable {

	@Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id")  
    private Student student;
    public Student getStudent() {
        return student;
    }
    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "section_id")  
    private Section section;
    public Section getSection() {
        return section;
    }
    @NotEmpty
    @Column(name = "grade")
    private char grade;
    @NotEmpty
    @Column(name = "isApproved")
    private boolean isApproved;
    @NotEmpty
    @Column(name = "Comments")
    private String comments;
}
