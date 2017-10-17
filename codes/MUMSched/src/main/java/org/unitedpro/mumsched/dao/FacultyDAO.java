package org.unitedpro.mumsched.dao;

import org.springframework.data.repository.CrudRepository;
import org.unitedpro.mumsched.domain.Faculty;

public interface FacultyDAO extends  CrudRepository<Faculty, Long>{
}
