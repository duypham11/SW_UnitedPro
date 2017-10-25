package org.unitedpro.mumsched.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.unitedpro.mumsched.domain.Entry;
import org.unitedpro.mumsched.service.IEntryService;

@Controller
@RequestMapping(value="/admin")
public class EntryAdminController {
	@Autowired
	IEntryService entryService;
	
	@RequestMapping(value="/entry_list", method = RequestMethod.GET)
	public ModelAndView list() {		
		ModelAndView model = new ModelAndView("admin/entry_list");
		List<Entry> entryList = entryService.getEntryList();				
		System.out.println("======list===" + entryList.size());
		model.addObject("entry_list", entryList);		
		return model;
	}
	
	@RequestMapping(value="/update_entry/{id}", method = RequestMethod.GET)
	public ModelAndView update(@PathVariable("id") long id) {
		System.out.println("======update===" );
		ModelAndView model = new ModelAndView("admin/entryform");
		Entry entry = entryService.getEntryById(id);
		return model.addObject("entryForm", entry);		
	}	
	@RequestMapping(value="/delete_entry/{id}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable("id") long id) {
		Entry entry = entryService.getEntryById(id);
		System.out.println("======delete===" + entry.getEntry_id());
		entryService.delete(entry);
		return new ModelAndView("redirect:/admin/entry_list");
	}	
	
	@RequestMapping(value="/add_entry", method = RequestMethod.GET)
	public ModelAndView add() {
		System.out.println("======add===" );
		ModelAndView model = new ModelAndView("admin/entryform");
		Entry entry = new Entry();
		model.addObject("entryForm", entry);		
		return model;
	}	

	@RequestMapping(value="/save_entry", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("entryForm") Entry entry) {
		System.out.println("======save===" + entry.getEntry_id());
		entryService.save(entry);		
		return new ModelAndView("redirect:/admin/entry_list");
	}	

}
