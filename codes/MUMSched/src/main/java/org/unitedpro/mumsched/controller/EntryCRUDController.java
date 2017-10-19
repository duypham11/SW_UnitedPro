package org.unitedpro.mumsched.controller;

import java.util.List;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.unitedpro.mumsched.domain.Entry;
import org.unitedpro.mumsched.domain.Student;
import org.unitedpro.mumsched.service.IEntryService;

@Controller
public class EntryCRUDController {
    @Autowired
    private IEntryService entryService;

    private Entry entry;
//	@RequestMapping(value = "/entryadmin")
//	public String newstudent(Model model){
//		Iterable<Entry> entryIterList = entryService.getAllEntry();
//		for(Entry e: entryIterList) {
//			System.out.println("======e===" + e.getEntryName());
//		}
//	    return "entryadmin";
//	}
	
    @RequestMapping(value = "/entryadmin",method = RequestMethod.GET)
    public Iterable<Entry> viewstudent(Model model){
        model.addAttribute("entries",entryService.getAllEntry());
       return entryService.getAllEntry();
    }
    
    @RequestMapping(value = "/entryadmin",method = RequestMethod.POST)
    public String save(HttpServletRequest request, Model model){
    	
    	entry = new Entry();
    	entry.setEntryName(request.getParameter("entryName"));
    	entry.setEntryName(request.getParameter("noFPP"));
    	entry.setEntryName(request.getParameter("noMPP"));
    	entry.setEntryName(request.getParameter("noOPTFPP"));
    	entry.setEntryName(request.getParameter("noOPTMPP"));
    	entry.setEntryName(request.getParameter("noOfUSRes"));
    	entryService.save(entry);
    	       
        return "entryadmin";
    }

}
