package org.unitedpro.mumsched.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView model = new ModelAndView("admin/entry_list");
		List<Entry> entryList = entryService.getEntryList();
		model.addObject("list", entryList);		
		return model;
	}
	
	@RequestMapping(value="/update{id}", method = RequestMethod.GET)
	public ModelAndView update(@PathVariable("id") long id) {
		ModelAndView model = new ModelAndView("admin/entryform");
		Entry entry = entryService.getEntryById(id);
		model.addObject("entryForm", entry);		
		return model;
	}	
	@RequestMapping(value="/delete{id}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable("id") long id) {
		ModelAndView model = new ModelAndView("admin/entryform");
		Entry entry = entryService.getEntryById(id);
		entryService.delete(entry);
		model.addObject("entryForm", entry);		
		return model;
	}	
	
	@RequestMapping(value="/add{id}", method = RequestMethod.GET)
	public ModelAndView add() {
		ModelAndView model = new ModelAndView("admin/entryform");
		Entry entry = new Entry();
		model.addObject("entryForm", entry);		
		return model;
	}	
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("entryForm") Entry entry) {
		entryService.save(entry);	
		
		return new ModelAndView("redirect:/admin/list");
	}	
}
