package org.unitedpro.mumsched.service;
import javax.persistence.EntityManager;

import org.unitedpro.mumsched.domain.*;

public interface StudentService {
	public void setEntityManager(EntityManager entityManager);
	public EntityManager getEntityManager();
	public void save(Student student);
	public Student getStudentById(Long id);
	public boolean delete(Student student);
	public boolean update(Student student);
}
