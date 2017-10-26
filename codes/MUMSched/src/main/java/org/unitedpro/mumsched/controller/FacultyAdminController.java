package org.unitedpro.mumsched.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.unitedpro.mumsched.domain.Faculty;
import org.unitedpro.mumsched.domain.Faculty;
import org.unitedpro.mumsched.service.IFacultyService;
import org.unitedpro.mumsched.service.IFacultyService;

@Controller
@RequestMapping(value = "/admin")
public class FacultyAdminController {
	@Autowired
	private IFacultyService facultyService;

	@RequestMapping(value = "/faculty_list", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView model = new ModelAndView("admin/faculty_list");
		List<Faculty> facultyList = facultyService.getFacultyList();
		model.addObject("faculty_list", facultyList);
		return model;
	}

	@RequestMapping(value = "/update_faculty/{id}", method = RequestMethod.GET)
	public ModelAndView update(@PathVariable("id") long id) {
		System.out.println("======update==faculty=");
		ModelAndView model = new ModelAndView("admin/facultyform");
		Faculty faculty = facultyService.getFacultyById(id);
		//List<Faculty> facultyList = facultyService.getFacultyList();
		//model.addObject("facultyList", facultyList);
		model.addObject("facultyForm", faculty);
		return model;
	}

	@RequestMapping(value = "/delete_faculty/{id}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable("id") long id) {
		Faculty faculty = facultyService.getFacultyById(id);
		System.out.println("======delete==faculty=" + faculty.getFaculty_id());
		facultyService.delete(faculty);
		return new ModelAndView("redirect:/admin/faculty_list");
	}

	@RequestMapping(value = "/add_faculty", method = RequestMethod.GET)
	public ModelAndView add() {
		System.out.println("======add=faculty==");
		ModelAndView model = new ModelAndView("admin/facultyform");
		Faculty faculty = new Faculty();
		//List<Faculty> facultyList = facultyService.getFacultyList();
		//model.addObject("facultyList", facultyList);
		model.addObject("facultyForm", faculty);
		return model;
	}

	@RequestMapping(value = "/save_faculty", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("facultyForm") Faculty faculty) {
		System.out.println("======save==faculty=");
		facultyService.save(faculty);
		return new ModelAndView("redirect:/admin/faculty_list");
	}
}
