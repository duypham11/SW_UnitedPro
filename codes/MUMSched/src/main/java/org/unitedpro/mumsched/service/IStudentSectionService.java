package org.unitedpro.mumsched.service;

import org.unitedpro.mumsched.domain.Student;
import org.unitedpro.mumsched.domain.Student_Section;

/**
 * Created by Duong Truong on 10/17/2017.
 */
public interface IStudentSectionService {
    void save(Student_Section studentsection);

    boolean delete(Student_Section studentsection);

    boolean update(Student_Section studentsection);

    Iterable<Student_Section> getAllByStudent(Student student);
}
