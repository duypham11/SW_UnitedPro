/*package org.unitedpro.mumsched.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.unitedpro.mumsched.domain.*;

public interface FacultyDAO extends  CrudRepository<Faculty, Long>{
	@Query("select f from Faculty f where f.faculty_id= :id")
	public Student findFacultyById(@Param("id") Long facultyId);
}
*/