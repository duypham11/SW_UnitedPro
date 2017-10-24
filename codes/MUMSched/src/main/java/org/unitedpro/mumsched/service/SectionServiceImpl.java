package org.unitedpro.mumsched.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.unitedpro.mumsched.dao.SectionDAO;
import org.unitedpro.mumsched.domain.Block;
import org.unitedpro.mumsched.domain.Section;
@Service
public class SectionServiceImpl implements ISectionService {
	@Autowired
	private SectionDAO sectionDAO;

	@Override
	public void save(Section section){
		sectionDAO.save(section);
	}

	@Override
	public Section getSectionById(Long id){
		return sectionDAO.findOne(id);
	}

	@Override
	public Iterable<Section> getAllSection(){
		return sectionDAO.findAll();
	}

	@Override
	public boolean delete(Section section){
		sectionDAO.delete(section);
		return true;
	}
	@Override
	public boolean update(Section section){
		sectionDAO.save(section);
		return true;
	}
	@Override
	public List<Section> getSectionList() {
		return sectionDAO.getSectionList();
	}
}
