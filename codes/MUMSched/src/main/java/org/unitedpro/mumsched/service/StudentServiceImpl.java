package org.unitedpro.mumsched.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.unitedpro.mumsched.dao.StudentDAO;
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
}