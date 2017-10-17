package org.unitedpro.mumsched.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.unitedpro.mumsched.domain.Faculty;

@Repository
public interface FacultyDAO extends  CrudRepository<Faculty, Long>{
}
