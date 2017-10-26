package org.unitedpro.mumsched.service;

import java.util.List;

<<<<<<< HEAD
import org.unitedpro.mumsched.domain.Block;
=======
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
>>>>>>> 2e0789f4a88a8b8d4b2ff11157e19e15db3449b8
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

<<<<<<< HEAD
    Iterable<Course> getAllCourse();
    
    List<Course> getCourseList();
=======
	void saveCourse(Course course, HttpServletRequest request);
	
	List<Course> getCourseList();
>>>>>>> 2e0789f4a88a8b8d4b2ff11157e19e15db3449b8
}
