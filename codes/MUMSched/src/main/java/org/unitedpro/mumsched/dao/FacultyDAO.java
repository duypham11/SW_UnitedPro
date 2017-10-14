package org.unitedpro.mumsched.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.unitedpro.mumsched.domain.Student;

public interface FacultyDAO {
	@Query("select f from Faculty f where f.faculty_id= :id")
	public Student findFacultyById(@Param("id") Long facultyId);
}
