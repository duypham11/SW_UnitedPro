package org.unitedpro.mumsched.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.unitedpro.mumsched.domain.Course;
import org.unitedpro.mumsched.service.ICourseService;

@Controller
@RequestMapping(value = "/admin")
public class CourseAdminController {
	@Autowired
	private ICourseService courseService;
	
	@RequestMapping(value = "/course_list", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView model = new ModelAndView("admin/course_list");
		List<Course> courseList = courseService.getCourseList();
		model.addObject("course_list", courseList);
		return model;
	}

	@RequestMapping(value = "/update_course/{id}", method = RequestMethod.GET)
	public ModelAndView update(@PathVariable("id") long id) {
		System.out.println("======update==course=");
		ModelAndView model = new ModelAndView("admin/courseform");
		Course course = courseService.getCourseById(id);
		model.addObject("courseForm", course);
		return model;
	}

	@RequestMapping(value = "/delete_course/{id}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable("id") long id) {
		Course course = courseService.getCourseById(id);
		System.out.println("======delete==course=" + course.getCourse_id());
		courseService.delete(course);
		return new ModelAndView("redirect:/admin/course_list");
	}

	@RequestMapping(value = "/add_course", method = RequestMethod.GET)
	public ModelAndView add() {
		System.out.println("======add=course==");
		ModelAndView model = new ModelAndView("admin/courseform");
		Course course = new Course();
		model.addObject("courseForm", course);
		return model;
	}

	@RequestMapping(value = "/save_course", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("courseForm") Course course) {
		System.out.println("======save==course=");
		courseService.save(course);
		return new ModelAndView("redirect:/admin/course_list");
	}
}
