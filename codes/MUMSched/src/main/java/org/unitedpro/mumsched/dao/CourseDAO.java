package org.unitedpro.mumsched.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.unitedpro.mumsched.domain.Course;

@Repository
public interface CourseDAO extends  CrudRepository <Course, Long> {

}
