package org.unitedpro.mumsched.dao;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.unitedpro.mumsched.domain.*;

@Repository
public interface StudentDAO extends  CrudRepository<Student, Long> {
}
