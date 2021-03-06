package org.unitedpro.mumsched.service;

import java.util.List;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.unitedpro.mumsched.domain.Student;

/**
 * Created by Duong Truong on 10/17/2017.
 */
public interface IStudentService {
    Student getStudentById(long id);

    Iterable<Student> getAllStudent();

    void createStudent(Student student);

    void deleteStudentById(long id);

    void deleteStudent(Student student);

    void updateStudent(Student student);

    void saveStudent(Student student, HttpServletRequest request);

    Student findStudentByEmail(String email);
    
    List<Student> getStudentList();
    
    void save(Student student);
    
    boolean delete(Student student);
}
