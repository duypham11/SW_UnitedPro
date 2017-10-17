package org.unitedpro.mumsched.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.unitedpro.mumsched.domain.Student;
import org.unitedpro.mumsched.service.IStudentService;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Duong Truong on 10/13/2017.
 */
@Controller
public class StudentController {
   @Autowired
   private IStudentService service;

    @RequestMapping(value="/newstudent",method = RequestMethod.GET)
    public String newstudent(HttpServletRequest request) {
        return "newstudent";
    }

    @RequestMapping(value = "/success",method = RequestMethod.POST)
    public String success(@RequestBody Student student){
        service.createStudent(student);
        return "success";
    }
}
