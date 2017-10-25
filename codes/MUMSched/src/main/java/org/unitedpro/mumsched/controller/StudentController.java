package org.unitedpro.mumsched.controller;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.unitedpro.mumsched.domain.Course;
import org.unitedpro.mumsched.domain.Section;
import org.unitedpro.mumsched.domain.Student;
import org.unitedpro.mumsched.domain.Student_Section;
import org.unitedpro.mumsched.service.ISectionService;
import org.unitedpro.mumsched.service.IStudentSectionService;
import org.unitedpro.mumsched.service.IStudentService;
import org.unitedpro.mumsched.service.UserDetailsImpl;

import java.util.Iterator;

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
        model.addAttribute("sections",sectionService.getAllSection());
        model.addAttribute("studentId",student.getStudent_id());
        return "registersection";
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String register(HttpServletRequest request, Model model) throws Exception {

        long sectionId = Long.parseLong(request.getParameter("sectionId"));

        section = sectionService.getSectionById(sectionId);

        if(checkPreCourse(student.getStudent_id(),section.getCourse())){
            throw new Exception("The Course has a perquisite course need to be completed");
        }
        student_section = new Student_Section();
        student_section.setStudent(student);
        student_section.setSection(section);
        student_section.setApproved(false);
//        student.addStudentSection(student_section);
//        section.addStudentSection(student_section);

//        studentService.updateStudent(student);
//        sectionService.update(section);


        long idExists = studentSectionService.findBySs_idExists();
        student_section.setSs_id(idExists+1);
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
        model.addAttribute("sections",studentSectionService.getAllByStudent(student.getStudent_id()));
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
    public String getstudent(Authentication authentication, Model model){
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        if(authentication.getAuthorities().toString().equals("[ROLE_STUDENT]")){
            student = studentService.findStudentByEmail(userDetails.getUsername());
        }

        return "home";
    }

    public Boolean checkPreCourse(long studentId, Course course){
        if(course.getPreCourses().size() == 0){
            return false;
        }

        Iterable<Section> PreCourseIterate = studentSectionService.getAllByStudent(studentId);
        for (Iterator<Section> it = PreCourseIterate.iterator(); it.hasNext(); ) {
            Section section = it.next();
            if(course.getPreCourses().contains(section.getCourse())){
                return false;
            }
        }
        return true;
    }
}
