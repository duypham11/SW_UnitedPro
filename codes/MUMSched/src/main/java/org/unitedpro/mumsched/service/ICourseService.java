package org.unitedpro.mumsched.service;

import java.util.List;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.unitedpro.mumsched.domain.Course;

/**
 * Created by Duong Truong on 10/17/2017.
 */
public interface ICourseService {
	void save(Course course);

	Course getCourseById(Long id);

	boolean delete(Course course);

	boolean deleteCourseById(long id);

	boolean update(Course course);

	Iterable<Course> getAllCourse();

	void saveCourse(Course course, HttpServletRequest request);
	
	List<Course> getCourseList();
}
