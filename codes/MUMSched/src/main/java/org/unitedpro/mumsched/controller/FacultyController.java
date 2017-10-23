package org.unitedpro.mumsched.controller;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.unitedpro.mumsched.domain.Faculty;
import org.unitedpro.mumsched.service.IFacultyService;

/**
 * Created by Duong Truong on 10/13/2017.
 */
@Controller
public class FacultyController {
    @Autowired
    private IFacultyService facultyService;

    private Faculty faculty;

    @RequestMapping(value = "/viewfaculty",method = RequestMethod.GET)
    public Iterable<Faculty> viewfaculty(Model model){
        model.addAttribute("faculties", facultyService.getAllFaculty());
       return facultyService.getAllFaculty();
    }

    @RequestMapping(value = "/newfaculty")
    public String newfaculty(Model model){
        return "newfaculty";
    }

    @RequestMapping(value = "/savefaculty",method = RequestMethod.POST)
    public String save(HttpServletRequest request, Model model){
        faculty = new Faculty();
        facultyService.saveFaculty(faculty, request);
        facultyService.save(faculty);
        String message = "The Faculty is registered with Faculty ID:" + faculty.getFaculty_id();
        model.addAttribute("message",message);
        
        return "success";
    }

    @RequestMapping(value = "/{facultyId}/editfaculty",method = RequestMethod.GET)
    public String editfaculty(@PathVariable("facultyId") long facultyId, HttpServletRequest request, Model model){
        model.addAttribute("facultyId",facultyId);
        faculty = facultyService.getFacultyById(facultyId);
        model.addAttribute("faculty", faculty);
        return "editfaculty";
    }

    @RequestMapping(value = "/{facultyId}/editfaculty",method = RequestMethod.POST)
    public String editedfaculty(@PathVariable("facultyId") long facultyId, HttpServletRequest request,Model model){
        faculty = facultyService.getFacultyById(facultyId);
        facultyService.saveFaculty(faculty, request);
        facultyService.update(faculty);

        String message = "Your profile has been updated";
        model.addAttribute("message",message);
        return "success";
    }

    @RequestMapping(value = "/{facultyId}/deletefaculty",method = RequestMethod.GET)
    public String deletefaculty(@PathVariable("facultyId") long facultyId, HttpServletRequest request,Model model){
        facultyService.deleteFacultyById(facultyId);
        String message = "The faculty with ID " + facultyId + " is deleted";
        model.addAttribute("message",message);
        return "success";
    }
}
