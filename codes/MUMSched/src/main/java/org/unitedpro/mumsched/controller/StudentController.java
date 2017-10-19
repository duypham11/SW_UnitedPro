package org.unitedpro.mumsched.controller;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.unitedpro.mumsched.domain.Section;
import org.unitedpro.mumsched.domain.Student;
import org.unitedpro.mumsched.domain.Student_Section;
import org.unitedpro.mumsched.service.ISectionService;
import org.unitedpro.mumsched.service.IStudentSectionService;
import org.unitedpro.mumsched.service.IStudentService;

/**
 * Created by Duong Truong on 10/13/2017.
 */
@Controller
public class StudentController {
    @Autowired
    private IStudentService studentService;

    @Autowired
    private ISectionService sectionService;

    @Autowired
    private IStudentSectionService studentSectionService;

    private Student student;

    private Section section;

    private Student_Section student_section;

    @RequestMapping(value = "/viewstudent",method = RequestMethod.GET)
    public Iterable<Student> viewstudent(Model model){
        model.addAttribute("students", studentService.getAllStudent());
       return studentService.getAllStudent();
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
        studentService.createStudent(student);
        System.out.println("save student===== " + student);
        String message = "Your Student is registered with student ID:" + student.getStudent_id();
        model.addAttribute("message",message);
        
        return "success";
    }

    @RequestMapping(value = "/{studentId}/registersection", method = RequestMethod.GET)
    public String registersection(@PathVariable("studentId") long studentId, Model model){
        model.addAttribute("studentId",studentId);
        return "registersection";
    }

    @RequestMapping(value = "/{studentId}/register",method = RequestMethod.POST)
    public String register(@PathVariable("studentId") long studentId, HttpServletRequest request, Model model){
        long sectionId = Long.parseLong(request.getParameter("sectionId"));
        section = sectionService.getSectionById(sectionId);
        student = studentService.getStudentById(studentId);

        student_section = new Student_Section();
        student_section.setStudent(student);
        student_section.setSection(section);
        student_section.setApproved(false);

        studentSectionService.save(student_section);
        return "success";
    }



}
