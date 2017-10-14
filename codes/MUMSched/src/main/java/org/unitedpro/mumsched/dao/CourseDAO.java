package org.unitedpro.mumsched.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.unitedpro.mumsched.domain.Entry;

public interface CourseDAO {
	@Query("select c from Course c where c.courseName = :courseName")
	public Entry findCourseByName(@Param("courseName") String courseName);
	
	@Query("select c from Course c where c.course_id = :courseId")
	public Entry findCourseById(@Param("courseId") long courseId);
	
	@Query("select c from Course c where c.courseCode = :courseCode")
	public Entry findCourseByCourseCode(@Param("courseCode") long courseCode);
}
