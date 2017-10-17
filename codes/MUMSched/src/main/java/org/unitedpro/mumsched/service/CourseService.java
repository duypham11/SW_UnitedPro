package org.unitedpro.mumsched.service;

import javax.persistence.EntityManager;

import org.unitedpro.mumsched.domain.Course;

public interface CourseService {
	public void setEntityManager(EntityManager entityManager);
	public EntityManager getEntityManager();
	public void save(Course course);
	public Course getCourseById(Long id);
	public boolean delete(Course course);
	public boolean update(Course course);
}
