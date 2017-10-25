package org.unitedpro.mumsched.service;

import java.util.List;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.unitedpro.mumsched.dao.StudentDAO;
import org.unitedpro.mumsched.domain.Course;
import org.unitedpro.mumsched.domain.Faculty;
import org.unitedpro.mumsched.domain.Student;

/**
 * Created by Duong Truong on 10/17/2017.
 */
@Service
public class StudentServiceImpl implements IStudentService {
    @Autowired
    private StudentDAO studentDAO;

    @Override
    public Student getStudentById(long id){
        return studentDAO.findOne(id);
    }

    @Override
    public Iterable<Student> getAllStudent(){
        return studentDAO.findAll();
    }

    @Override
    public void createStudent(Student student){
        studentDAO.save(student);
    }

    @Override
    public void deleteStudentById(long id){
        studentDAO.delete(id);
    }

    @Override
    public void deleteStudent(Student student){
        studentDAO.delete(student);
    }

    @Override
    public void updateStudent(Student student){
        studentDAO.save(student);
    }

    @Override
    public void saveStudent(Student student, HttpServletRequest request) {
        student.setFirstName(request.getParameter("firstName"));
        student.setLastName(request.getParameter("lastName"));
        student.setPassword(request.getParameter("password"));
        student.setEmail(request.getParameter("email"));
        student.setDOB(request.getParameter("DOB"));
    }

    @Override
    public Student findStudentByEmail(String email) {
        return studentDAO.findStudentByEmail(email);
    }
    
    @Override
	public List<Student> getStudentList() {
		return studentDAO.getStudentList();
	}
    
    @Override
	public void save(Student student) {
		studentDAO.save(student);
	}
    
    @Override
	public boolean delete(Student student) {
		studentDAO.delete(student);
		return true;
	}
}
