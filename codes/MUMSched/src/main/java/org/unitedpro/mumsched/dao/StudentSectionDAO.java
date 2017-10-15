package org.unitedpro.mumsched.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.unitedpro.mumsched.domain.*;

public interface StudentSectionDAO {//extends  CrudRepository <Student_Section, Long>{
	//@Query("select sc.student_id from Student_Section sc where sc.student_id= :id")
	//public Student findSectionsByStudentId(@Param("id") Long studentId);
}
