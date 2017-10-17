package org.unitedpro.mumsched.service;

import javax.persistence.EntityManager;

import org.unitedpro.mumsched.domain.Faculty;

public interface FacultyService {
	public void setEntityManager(EntityManager entityManager);
	public EntityManager getEntityManager();
	public void save(Faculty faculty);
	public Faculty getFacultyById(Long id);
	public boolean delete(Faculty faculty);
	public boolean update(Faculty faculty);
}
