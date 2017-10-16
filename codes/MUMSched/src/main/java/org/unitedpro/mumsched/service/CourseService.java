package org.unitedpro.mumsched.service;

import org.unitedpro.mumsched.domain.Course;

public interface CourseService {
	public void save(Course course);
	public Course getCourseById(Long id);
	public boolean delete(Course course);
	public Course update(Course course);
}
