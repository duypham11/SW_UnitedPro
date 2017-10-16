package org.unitedpro.mumsched.service;

import org.unitedpro.mumsched.domain.Student_Section;

public interface StudentSectionService {
	public void save(Student_Section studentsection);
	public boolean delete(Student_Section studentsection);
	public Student_Section update(Student_Section studentsection);
}
