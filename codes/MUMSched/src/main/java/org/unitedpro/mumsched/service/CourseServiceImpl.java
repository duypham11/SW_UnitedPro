package org.unitedpro.mumsched.service;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.unitedpro.mumsched.dao.CourseDAO;
import org.unitedpro.mumsched.domain.Course;
@Service
public class CourseServiceImpl implements ICourseService {
	@Autowired
	private CourseDAO courseDAO;

	@Override
	public void save(Course course){
		courseDAO.save(course);
	}
	@Override
	public Course getCourseById(Long id){
		return courseDAO.findOne(id);
	}
	@Override
	public boolean delete(Course course){
		courseDAO.delete(course);
		return true;
	}

	@Override
	public boolean deleteById(long id){
		courseDAO.delete(id);
		return true;
	}

	@Override
	public boolean update(Course course){
		courseDAO.save(course);
		return true;
	}
}
