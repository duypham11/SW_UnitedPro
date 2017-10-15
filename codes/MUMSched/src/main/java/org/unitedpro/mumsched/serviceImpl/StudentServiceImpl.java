package org.unitedpro.mumsched.serviceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.unitedpro.mumsched.domain.*;
import org.unitedpro.mumsched.service.StudentService;
import org.unitedpro.mumsched.dao.*;


@Service
public class StudentServiceImpl implements StudentService{
	@Autowired
	StudentDAO studentDAO;
	
	public void save(Student student){
		studentDAO.save(student);
		return ;
	}

	public Student getStudentById(Long studentId) {
		return studentDAO.findStudentById(studentId);
	}

	@Override
	public void delete(Student student) {
		studentDAO.delete(student);
		
	}

	@Override
	public void update(Long id, Student student) {
		studentDAO.findStudentById(id);
		
	}
}
