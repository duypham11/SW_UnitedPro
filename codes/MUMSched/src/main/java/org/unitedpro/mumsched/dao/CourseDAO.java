/*package org.unitedpro.mumsched.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.unitedpro.mumsched.domain.*;

public interface CourseDAO extends  CrudRepository <Course, Long> {
	@Query("select c from Course c where c.courseName = :courseName")
	public Entry findCourseByName(@Param("courseName") String courseName);
	
	@Query("select c from Course c where c.course_id = :courseId")
	public Entry findCourseById(@Param("courseId") Long courseId);
	
	@Query("select c from Course c where c.courseCode = :courseCode")
	public Entry findCourseByCourseCode(@Param("courseCode") Long courseCode);
}
*/