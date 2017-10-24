package org.unitedpro.mumsched.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.unitedpro.mumsched.domain.Section;
import org.unitedpro.mumsched.domain.Entry;
import org.unitedpro.mumsched.service.IBlockService;
import org.unitedpro.mumsched.service.IEntryService;
import org.unitedpro.mumsched.service.ISectionService;

@Controller
@RequestMapping(value="/admin")
public class SectionAdminController {
	@Autowired
	private IBlockService blockService;
	@Autowired
	private IEntryService entryService;	
	@Autowired
	private ISectionService sectionService;
	
	@RequestMapping(value="/section_list", method = RequestMethod.GET)
	public ModelAndView list() {		
		ModelAndView model = new ModelAndView("admin/section_list");
		List<Section> sectionList = sectionService.getSectionList();				
		System.out.println("======list=section==" + sectionList.size());
		model.addObject("section_list", sectionList);		
		return model;
	}
	
	@RequestMapping(value="/update_section/{id}", method = RequestMethod.GET)
	public ModelAndView update(@PathVariable("id") long id) {
		System.out.println("======update==section=" );
		ModelAndView model = new ModelAndView("admin/sectionform");
		Section section = sectionService.getSectionById(id);
		return model.addObject("sectionForm", section);		
	}
	
	@RequestMapping(value="/delete_section/{id}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable("id") long id) {
		Section section = sectionService.getSectionById(id);
		System.out.println("======delete==section=" + section.getSection_id());
		sectionService.delete(section);
		return new ModelAndView("redirect:/admin/section_list");
	}	
	
	@RequestMapping(value="/add_section", method = RequestMethod.GET)
	public ModelAndView add() {
		System.out.println("======add=section==" );
		ModelAndView model = new ModelAndView("admin/sectionform");
		Section section = new Section();
		List<Entry> entryList = entryService.getEntryList();
		model.addObject("sectionForm", section);
		model.addObject("entryList", entryList);
		return model;
	}	

	@RequestMapping(value="/save_section", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("sectionForm") Section section) {
		System.out.println("======save==section=" );
		sectionService.save(section);		
		return new ModelAndView("redirect:/admin/section_list");
	}	
}
