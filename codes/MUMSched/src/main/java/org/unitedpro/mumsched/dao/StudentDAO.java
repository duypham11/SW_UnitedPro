package org.unitedpro.mumsched.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.unitedpro.mumsched.domain.Faculty;
import org.unitedpro.mumsched.domain.Student;

@Repository
public interface StudentDAO extends  CrudRepository<Student, Long> {
    Student findStudentByEmail(String email);
    
    @Query( "select s from Student s" )
	List<Student> getStudentList();
}
