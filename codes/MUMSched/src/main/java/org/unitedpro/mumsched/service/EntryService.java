package org.unitedpro.mumsched.service;

import javax.persistence.EntityManager;

import org.unitedpro.mumsched.domain.Entry;

public interface EntryService {
	public void setEntityManager(EntityManager entityManager);
	public EntityManager getEntityManager();
	public void save(Entry entry);
	public Entry getEntryById(Long id);
	public boolean delete(Entry entry);
	public boolean update(Entry entry);
}
