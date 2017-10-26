package org.unitedpro.mumsched.service;

import java.util.List;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.unitedpro.mumsched.dao.CourseDAO;
import org.unitedpro.mumsched.domain.Course;

@Service
public class CourseServiceImpl implements ICourseService {
	@Autowired
	private CourseDAO courseDAO;

	@Override
	public void save(Course course) {
		courseDAO.save(course);
	}

	@Override
	public Course getCourseById(Long id) {
		return courseDAO.findOne(id);
	}

	@Override
	public Iterable<Course> getAllCourse() {
		return courseDAO.findAll();
	}

	@Override
	public boolean delete(Course course) {
		courseDAO.delete(course);
		return true;
	}

	@Override
	public boolean deleteCourseById(long id) {
		courseDAO.delete(id);
		return true;
	}

	@Override
	public boolean update(Course course) {
		courseDAO.save(course);
		return true;
	}
	@Override
	public List<Course> getCourseList() {
		return courseDAO.getCourseList();
	}
	@Override
	public void saveCourse(Course course, HttpServletRequest request) {
		course.setCourse_id(Integer.parseInt(request.getParameter("courseId")));
		course.setCourseCode(request.getParameter("courseCode"));
		course.setCourseName(request.getParameter("courseName"));
		course.setCourseDescription(request.getParameter("courseDescription"));
	}
}
