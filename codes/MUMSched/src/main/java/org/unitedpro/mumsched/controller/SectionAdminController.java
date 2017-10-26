package org.unitedpro.mumsched.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.unitedpro.mumsched.domain.Section;
import org.unitedpro.mumsched.domain.Block;
import org.unitedpro.mumsched.domain.Course;
import org.unitedpro.mumsched.domain.Entry;
import org.unitedpro.mumsched.service.IBlockService;
import org.unitedpro.mumsched.service.ICourseService;
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
	@Autowired
	private ICourseService courseService;
	
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
		ModelAndView model = new ModelAndView("admin/sectionupdateform");
		Section section = sectionService.getSectionById(id);
		List<Block> blockList = blockService.getBlockList();
		model.addObject("blockList", blockList);
		
		List<Course> courseList = courseService.getCourseList();
		model.addObject("courseList", courseList);		
		return model.addObject("sectionForm", section);		
	}
	
	@RequestMapping(value="/delete_section/{id}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable("id") long id) {
		Section section = sectionService.getSectionById(id);
		System.out.println("======delete==section=" + section.getSection_id());
		Block block = section.getBlock();
		block.delete(section);
		sectionService.delete(section);
		return new ModelAndView("redirect:/admin/section_list");
	}	
	
	@RequestMapping(value="/add_section", method = RequestMethod.GET)
	public ModelAndView add() {
		System.out.println("======add=section==" );
		ModelAndView model = new ModelAndView("admin/sectionform");
		Section section = new Section();
		List<Course> courseList = courseService.getCourseList();
		List<Block> blockList = blockService.getBlockList();
		
		model.addObject("sectionForm", section);
		model.addObject("blockList", blockList);
		model.addObject("courseList", courseList);

		return model;
	}	

	@RequestMapping(value="/save_section", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("block") @Valid Block block, BindingResult bindingResultBlock,
				@ModelAttribute("sectionForm") @Valid Section section, BindingResult bindingResultSection) {
		System.out.println("======save==section=" );		
		sectionService.save(section);
		block.addSection(section);
		blockService.update(block);
		return new ModelAndView("redirect:/admin/section_list");
	}	
	
	
	
	@RequestMapping(value="/update_section", method = RequestMethod.POST)
	public ModelAndView update(@ModelAttribute("block") @Valid Block block, BindingResult bindingResultBlock,
				@ModelAttribute("sectionForm") @Valid Section section, BindingResult bindingResultSection) {
		System.out.println("======save==section=" );		
		sectionService.save(section);
		return new ModelAndView("redirect:/admin/section_list");
	}
}

