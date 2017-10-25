package org.unitedpro.mumsched.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.unitedpro.mumsched.domain.Block;
import org.unitedpro.mumsched.domain.Entry;
import org.unitedpro.mumsched.domain.Section;
import org.unitedpro.mumsched.service.IBlockService;
import org.unitedpro.mumsched.service.IEntryService;

@Controller
@RequestMapping(value="/admin")
public class BlockAdminController {
	@Autowired
	private IBlockService blockService;
	@Autowired
	private IEntryService entryService;
	
	@RequestMapping(value="/block_list", method = RequestMethod.GET)
	public ModelAndView list() {		
		ModelAndView model = new ModelAndView("admin/block_list");
		List<Block> blockList = blockService.getBlockList();				
		System.out.println("======list=block==" + blockList.size());
		String sections = "";
		for(Block b: blockList){
			for(Section s: b.getSections()) {
				sections += s.getSectionName() +"(" + s.getRoomNo()+")";
			}
			System.out.println("======list=block==" + sections);
			sections="";
			
		}
		model.addObject("block_list", blockList);		
		return model;
	}
	
	@RequestMapping(value="/update_block/{id}", method = RequestMethod.GET)
	public ModelAndView update(@PathVariable("id") long id) {
		System.out.println("======update==block=" );
		ModelAndView model = new ModelAndView("admin/blockform");
		Block block = blockService.getBlockById(id);		
		List<Entry> entryList = entryService.getEntryList();
		model.addObject("entryList", entryList);
		return model.addObject("blockForm", block);// new ModelAndView("redirect:/admin/add_block");
	}
	
	@RequestMapping(value="/delete_block/{id}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable("id") long id) {
		Block block = blockService.getBlockById(id);
		System.out.println("======delete==block=" + block.getBlock_id());
		blockService.delete(block);
		return new ModelAndView("redirect:/admin/block_list");
	}	
	
	@RequestMapping(value="/add_block", method = RequestMethod.GET)
	public ModelAndView add() {
		System.out.println("======add=block==" );
		ModelAndView model = new ModelAndView("admin/blockform");
		Block block = new Block();

		List<Entry> entryList = entryService.getEntryList();
		model.addObject("entryList", entryList);
		model.addObject("blockForm", block);
		
		return model;
	}	

	@RequestMapping(value="/save_block", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("entry") @Valid Entry entry, BindingResult bindingResultEntry,
			@ModelAttribute("blockForm") @Valid Block block, BindingResult bindingResultBlock) {

		blockService.save(block);		
		return new ModelAndView("redirect:/admin/block_list");
	}	
}
