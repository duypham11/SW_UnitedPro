package org.unitedpro.mumsched.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Duong Truong on 10/13/2017.
 */
@Controller
public class MumSchedController {
    private String SectionId;

    public String getSectionId() {
        return SectionId;
    }

    public void setSectionId(String sectionId) {
        SectionId = sectionId;
    }

    @RequestMapping(value="/registerSection")
    public String registerSection(HttpServletRequest request) {
        return "registerSection";
    }

    @RequestMapping(value = "/success")
    public String success(Model model, HttpServletRequest request){
        request.getParameter("sectionID");
        setSectionId(request.getParameter("sectionID"));
        System.out.println(getSectionId());
        model.addAttribute("message", getSectionId());
        return "success";
    }
}
