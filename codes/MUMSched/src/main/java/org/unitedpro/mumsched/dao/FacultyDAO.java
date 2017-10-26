package org.unitedpro.mumsched.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.unitedpro.mumsched.domain.Faculty;

@Repository
public interface FacultyDAO extends  CrudRepository<Faculty, Long>{
    Faculty findFacultyByEmail(String email);

	@Query( "select f from Faculty f" )
	List<Faculty> getFacultyList();
}
