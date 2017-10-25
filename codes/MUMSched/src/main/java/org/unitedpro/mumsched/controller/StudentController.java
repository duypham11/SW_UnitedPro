package org.unitedpro.mumsched.controller;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.unitedpro.mumsched.domain.Section;
import org.unitedpro.mumsched.domain.Student;
import org.unitedpro.mumsched.domain.Student_Section;
import org.unitedpro.mumsched.service.ISectionService;
import org.unitedpro.mumsched.service.IStudentSectionService;
import org.unitedpro.mumsched.service.IStudentService;
import org.unitedpro.mumsched.service.UserDetailsImpl;

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

    private static Student student;

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
        studentService.saveStudent(student,request);
        studentService.createStudent(student);
        System.out.println("save student===== " + student);
        String message = "Your Student is registered with student ID:" + student.getStudent_id();
        model.addAttribute("message",message);
        
        return "success";
    }

    @RequestMapping(value = "/registersection", method = RequestMethod.GET)
    public String registersection(Model model){
        model.addAttribute("studentId",student.getStudent_id());
        return "registersection";
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String register(HttpServletRequest request, Model model){

        long sectionId = Long.parseLong(request.getParameter("sectionId"));
        section = sectionService.getSectionById(sectionId);
        student_section = new Student_Section();
        student_section.setStudent(student);
        student_section.setSection(section);
        student_section.setApproved(false);
        student.addStudentSection(student_section);
        section.addStudentSection(student_section);

        studentService.updateStudent(student);
        sectionService.update(section);

        studentSectionService.save(student_section);

        String message = "You have register the Section: " + section.getSectionName() +
                ". And your register ID is: " +  student_section.getSs_id();
        model.addAttribute("message",message);
        return "success";
    }

    @RequestMapping(value = "/editstudent",method = RequestMethod.GET)
    public String editstudent(Model model){
        model.addAttribute("studentId",student.getStudent_id());
        model.addAttribute("student",student);
        return "editstudent";
    }

    @RequestMapping(value = "/editstudent",method = RequestMethod.POST)
    public String editedstudent(HttpServletRequest request,Model model){
        studentService.saveStudent(student,request);
        studentService.updateStudent(student);

        String message = "Your profile has been updated";
        model.addAttribute("message",message);
        return "success";
    }

    @RequestMapping(value = "/deletestudent",method = RequestMethod.GET)
    public String deletestudent(Model model){
        studentService.deleteStudentById(student.getStudent_id());
        String message = "The student with ID " + student.getStudent_id() + " is deleted";
        model.addAttribute("message",message);
        return "success";
    }


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getstudent(HttpServletRequest request, Authentication authentication, Model model){
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        student = studentService.findStudentByEmail(userDetails.getUsername());
        return "home";
    }
}
