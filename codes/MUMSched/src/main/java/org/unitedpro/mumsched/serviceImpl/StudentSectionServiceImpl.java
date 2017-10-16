package org.unitedpro.mumsched.serviceImpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.unitedpro.mumsched.domain.Student_Section;
import org.unitedpro.mumsched.service.StudentSectionService;

@Service
public class StudentSectionServiceImpl implements StudentSectionService{

	//private Student_Section studentSection;
	private EntityManager entityManager;
	
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
	    this.entityManager = entityManager;
	}
	public EntityManager getEntityManager() {
	    return entityManager;
	}
	@Override
	public void save(Student_Section studentsection) {
		// TODO Auto-generated method stub
		entityManager.persist(studentsection);
		//entityManager.flush();	
	}

	@Override
	public boolean delete(Student_Section studentsection) {
		// TODO Auto-generated method stub
		try {
	         entityManager.remove(studentsection);
	    } catch (Exception ex) {
	        return false;
	    }
	    return true;
	}

	@Override
	public Student_Section update(Student_Section studentsection) {
		// TODO Auto-generated method stub
	    try{
	        return entityManager.merge(studentsection);
	     } catch(Exception ex) {
	         return null;
	     }
	}

}
