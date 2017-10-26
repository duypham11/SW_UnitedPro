package org.unitedpro.mumsched.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.unitedpro.mumsched.domain.Student;
import org.unitedpro.mumsched.domain.Faculty;
import org.unitedpro.mumsched.service.IStudentService;
import org.unitedpro.mumsched.service.IFacultyService;

@Controller
@RequestMapping(value = "/admin")
public class StudentAdminController {
	@Autowired
	private IStudentService studentService;

	@RequestMapping(value = "/student_list", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView model = new ModelAndView("admin/student_list");
		List<Student> studentList = studentService.getStudentList();
		model.addObject("student_list", studentList);
		return model;
	}

	@RequestMapping(value = "/update_student/{id}", method = RequestMethod.GET)
	public ModelAndView update(@PathVariable("id") long id) {
		System.out.println("======update==student=");
		ModelAndView model = new ModelAndView("admin/studentform");
		Student student = studentService.getStudentById(id);
		//List<Faculty> facultyList = facultyService.getFacultyList();
		//model.addObject("facultyList", facultyList);
		model.addObject("studentForm", student);
		return model;
	}

	@RequestMapping(value = "/delete_student/{id}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable("id") long id) {
		Student student = studentService.getStudentById(id);
		System.out.println("======delete==student=" + student.getStudent_id());
		studentService.delete(student);
		return new ModelAndView("redirect:/admin/student_list");
	}

	@RequestMapping(value = "/add_student", method = RequestMethod.GET)
	public ModelAndView add() {
		System.out.println("======add=student==");
		ModelAndView model = new ModelAndView("admin/studentform");
		Student student = new Student();
		//List<Faculty> facultyList = facultyService.getFacultyList();
		//model.addObject("facultyList", facultyList);
		model.addObject("studentForm", student);
		return model;
	}

	@RequestMapping(value = "/save_student", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("studentForm") Student student) {
		System.out.println("======save==student=");
		studentService.save(student);
		return new ModelAndView("redirect:/admin/student_list");
	}
}
