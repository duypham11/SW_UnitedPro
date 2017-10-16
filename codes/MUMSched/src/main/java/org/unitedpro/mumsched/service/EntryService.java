package org.unitedpro.mumsched.service;

import org.unitedpro.mumsched.domain.Entry;

public interface EntryService {
	public void save(Entry entry);
	public Entry getEntryById(Long id);
	public boolean delete(Entry entry);
	public Entry update(Entry entry);
}
