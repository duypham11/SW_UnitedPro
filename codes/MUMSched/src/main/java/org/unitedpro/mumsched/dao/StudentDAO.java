package org.unitedpro.mumsched.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.unitedpro.mumsched.domain.Student;

@Repository
public interface StudentDAO extends  CrudRepository<Student, Long> {
    Student findStudentByEmail(String email);
}
