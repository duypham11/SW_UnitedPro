package org.unitedpro.mumsched.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.unitedpro.mumsched.domain.Student;
import org.unitedpro.mumsched.service.IStudentService;
import org.unitedpro.mumsched.service.StudentServiceImpl;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Duong Truong on 10/13/2017.
 */
@Controller
public class StudentController {
    @Autowired
    private IStudentService service;

    @RequestMapping(value = "/viewstudent",method = RequestMethod.GET)
    public Iterable<Student> viewstudent(){
       return service.getAllStudent();
    }

    @RequestMapping(value = "/newstudent",method = RequestMethod.POST)
    public String newstudent(@RequestBody Student student){
        service.createStudent(student);
        return "newStudent";
    }


}
