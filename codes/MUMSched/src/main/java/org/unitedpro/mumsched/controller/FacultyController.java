package org.unitedpro.mumsched.controller;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.unitedpro.mumsched.domain.Faculty;
import org.unitedpro.mumsched.service.IFacultyService;
import org.unitedpro.mumsched.service.UserDetailsImpl;

/**
 * Created by Duong Truong on 10/13/2017.
 */
@Controller
public class FacultyController {
    @Autowired
    private IFacultyService facultyService;

    public static Faculty faculty = new Faculty();

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

    @RequestMapping(value = "/editfaculty",method = RequestMethod.GET)
    public String editfaculty(Model model){
        model.addAttribute("facultyId",faculty.getFaculty_id());
        model.addAttribute("faculty", faculty);
        return "editfaculty";
    }

    @RequestMapping(value = "/editfaculty",method = RequestMethod.POST)
    public String editedfaculty(Authentication authentication, HttpServletRequest request, Model model){
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        faculty = facultyService.findFacultyByEmail(userDetails.getUsername());
        facultyService.saveFaculty(faculty, request);
        facultyService.update(faculty);

        String message = "Your profile has been updated";
        model.addAttribute("message",message);
        return "success";
    }

    @RequestMapping(value = "/deletefaculty",method = RequestMethod.GET)
    public String deletefaculty(Model model){
        facultyService.deleteFacultyById(faculty.getFaculty_id());
        String message = "The faculty with ID " + faculty.getFaculty_id() + " is deleted";
        model.addAttribute("message",message);
        return "success";
    }

//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public String getfaculty(HttpServletRequest request, Authentication authentication, Model model){
//        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
//        faculty = facultyService.findFacultyByEmail(userDetails.getUsername());
//        return "home";
//    }
}
