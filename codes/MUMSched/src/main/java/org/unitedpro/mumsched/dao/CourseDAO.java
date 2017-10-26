package org.unitedpro.mumsched.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.unitedpro.mumsched.domain.Block;
import org.unitedpro.mumsched.domain.Course;

@Repository
public interface CourseDAO extends  CrudRepository <Course, Long> {
	@Query( "select c from Course c" )
	List<Course> getCourseList();
}
