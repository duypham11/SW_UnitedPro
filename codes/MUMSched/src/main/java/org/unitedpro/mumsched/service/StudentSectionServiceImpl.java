package org.unitedpro.mumsched.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.unitedpro.mumsched.dao.StudentSectionDAO;
import org.unitedpro.mumsched.domain.Student_Section;

@Service
public class StudentSectionServiceImpl implements IStudentSectionService {
	@Autowired
	private StudentSectionDAO studentSectionDAO;

	@Override
	public void save(Student_Section studentsection){
		studentSectionDAO.save(studentsection);
	}
	@Override
	public boolean delete(Student_Section studentsection){
		studentSectionDAO.delete(studentsection);
		return true;
	}
	@Override
	public boolean update(Student_Section studentsection){
		studentSectionDAO.save(studentsection);
		return true;
	}

//	@Override
//	public Iterable<Student_Section> getAllByStudent(Student student){
//		return studentSectionDAO.getAllByStudent();
//	}
}
