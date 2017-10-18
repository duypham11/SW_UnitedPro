package org.unitedpro.mumsched.controller;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.unitedpro.mumsched.domain.Student;
import org.unitedpro.mumsched.service.IStudentService;

import java.util.List;

/**
 * Created by Duong Truong on 10/13/2017.
 */
@Controller
public class StudentController {
    @Autowired
    private IStudentService service;

    private Student student;

    @RequestMapping(value = "/viewstudent",method = RequestMethod.GET)
    public Iterable<Student> viewstudent(Model model){
        List<Student> students = (List<Student>) service.getAllStudent();
        for(Student student:students){
            System.out.println(student.getStudent_id());
        }

        model.addAttribute("message",service.getAllStudent());
       return service.getAllStudent();
    }

    @RequestMapping(value = "/newstudent")
    public String newstudent(Model model){
        return "newstudent";
    }

    @RequestMapping(value = "/savestudent",method = RequestMethod.POST)
    public String save(HttpServletRequest request, Model model){
        student = new Student();
        student.setFirstName(request.getParameter("firstName"));
        student.setLastName(request.getParameter("lastName"));
        student.setPassword(request.getParameter("password"));
        student.setEmail(request.getParameter("email"));
        student.setDOB(request.getParameter("DOB"));
        service.createStudent(student);
        System.out.println("save student===== " + student);
        model.addAttribute("message",student.getStudent_id());
        
        return "savestudent";
    }


}
