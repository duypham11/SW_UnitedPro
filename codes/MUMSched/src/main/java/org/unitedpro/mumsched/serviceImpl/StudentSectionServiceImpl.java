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
		entityManager.getTransaction().begin();
		entityManager.persist(studentsection);
		//entityManager.flush();	
		entityManager.getTransaction().commit();
	}

	@Override
	public boolean delete(Student_Section studentsection) {
		// TODO Auto-generated method stub
		try {
			entityManager.getTransaction().begin();
	         entityManager.remove(studentsection);
	         entityManager.getTransaction().commit();
	         return true;
	    } catch (Exception ex) {
	        return false;
	    }
	}

	@Override
	public boolean update(Student_Section studentsection) {
		// TODO Auto-generated method stub
	    try{
	    	entityManager.getTransaction().begin();
	        entityManager.merge(studentsection);
	        entityManager.getTransaction().commit();
	        return true;
	     } catch(Exception ex) {
	         return false;
	     }
	}

}
