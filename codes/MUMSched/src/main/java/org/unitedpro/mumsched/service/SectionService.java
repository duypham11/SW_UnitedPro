package org.unitedpro.mumsched.service;

import javax.persistence.EntityManager;

import org.unitedpro.mumsched.domain.Section;

public interface SectionService {
	public void setEntityManager(EntityManager entityManager);
	public EntityManager getEntityManager();
	public void save(Section section);
	public Section getSectionById(Long id);
	public boolean delete(Section section);
	public boolean update(Section section);
}
