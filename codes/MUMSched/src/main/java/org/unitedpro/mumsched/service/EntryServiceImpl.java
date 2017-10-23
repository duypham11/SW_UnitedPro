package org.unitedpro.mumsched.service;

import java.util.List;

import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.unitedpro.mumsched.dao.EntryDAO;
import org.unitedpro.mumsched.domain.Entry;
@Service
public class EntryServiceImpl implements IEntryService {
	@Autowired
	private EntryDAO entryDAO;

	@Override
	public void save(Entry entry){
		entryDAO.save(entry);
	}

	@Override
	public Entry getEntryById(Long id){
		return entryDAO.findOne(id);
	}

	@Override
	public boolean delete(Entry entry){
		entryDAO.delete(entry);
		return true;
	}

	@Override
	public boolean update(Entry entry){
		entryDAO.save(entry);
		return true;
	}

	@Override
	public Iterable<Entry> getAllEntry() {
		return entryDAO.findAll();
	}

	@Override
	public List<Entry> getEntryList() {		
		return Lists.newArrayList(entryDAO.findAll());
	}
}
