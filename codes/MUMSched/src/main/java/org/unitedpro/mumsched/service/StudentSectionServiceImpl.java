package org.unitedpro.mumsched.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.unitedpro.mumsched.dao.StudentSectionDAO;
import org.unitedpro.mumsched.domain.Section;
import org.unitedpro.mumsched.domain.Student_Section;

@Service
public class StudentSectionServiceImpl implements IStudentSectionService {
	@Autowired
	private StudentSectionDAO studentSectionDAO;

	@Override
	public void save(Student_Section studentsection){
		studentSectionDAO.save(studentsection);
	}

	public Iterable<Student_Section> findAll(){
		return studentSectionDAO.findAll();
	}

	@Override
	public long findBySs_idExists() {
		return studentSectionDAO.findBySs_idExists();
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

	@Override
	public Iterable<Section> getAllByStudent(long studentID){
		return studentSectionDAO.getAllByStudent_Student_id(studentID);
	}
}
