package org.unitedpro.mumsched.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.unitedpro.mumsched.JPAUtility;
import org.unitedpro.mumsched.domain.Student;
import org.unitedpro.mumsched.service.StudentService;
import org.unitedpro.mumsched.serviceImpl.StudentServiceImpl;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.Date;

/**
 * Created by Duong Truong on 10/16/2017.
 */
@Controller
public class StudentController {
    EntityManager entityManager;
    StudentServiceImpl studentService;
    Student student;
    public StudentController(){
        
        entityManager = JPAUtility.getEntityManager();
        studentService = new StudentServiceImpl();
        studentService.setEntityManager(entityManager);
    }

    @RequestMapping(value = "/newstudent")
    public String newstudent (Model model){
        return "newStudent";
    }

    @RequestMapping(value = "/savestudent")
    public String savestudent (HttpServletRequest request, Model model){
    	student = new Student();
        student.setFirstName(request.getParameter("firstName"));
        student.setLastName(request.getParameter("lastName"));

        System.out.println("before=========");
        student.setDOB(LocalDate.parse(request.getParameter("dob")));
        System.out.println(student.getDOB());
        System.out.println("after=========");

        student.setDOB(LocalDate.parse(request.getParameter("dob")));

        student.setEmail(request.getParameter("email"));
        studentService.save(student);
        return "saveStudent";
    }
}
