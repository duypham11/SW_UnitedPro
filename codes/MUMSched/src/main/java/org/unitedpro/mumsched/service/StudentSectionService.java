package org.unitedpro.mumsched.service;

import javax.persistence.EntityManager;

import org.unitedpro.mumsched.domain.Student_Section;

public interface StudentSectionService {
	public void setEntityManager(EntityManager entityManager);
	public EntityManager getEntityManager();
	public void save(Student_Section studentsection);
	public boolean delete(Student_Section studentsection);
	public boolean update(Student_Section studentsection);
}
