package org.unitedpro.mumsched.service;

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
}
