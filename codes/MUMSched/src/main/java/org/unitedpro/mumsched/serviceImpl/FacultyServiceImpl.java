package org.unitedpro.mumsched.serviceImpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.unitedpro.mumsched.domain.Faculty;
import org.unitedpro.mumsched.service.FacultyService;

@Service
public class FacultyServiceImpl implements FacultyService{

	//private Faculty faculty;
	private EntityManager entityManager;
	
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
	    this.entityManager = entityManager;
	}
	public EntityManager getEntityManager() {
	    return entityManager;
	}

	@Override
	public void save(Faculty faculty) {
		// TODO Auto-generated method stub
		entityManager.getTransaction().begin();
		entityManager.persist(faculty);
		//entityManager.flush();
		entityManager.getTransaction().commit();
	}

	@Override
	public Faculty getFacultyById(Long id) {
		// TODO Auto-generated method stub
		return entityManager.find(Faculty.class, id);
	}

	@Override
	public boolean delete(Faculty faculty) {
		// TODO Auto-generated method stub
		try {
			entityManager.getTransaction().begin();
	        entityManager.remove(faculty);
	        entityManager.getTransaction().commit();
	        return true;
	    } catch (Exception ex) {
	        return false;
	    }
	}

	@Override
	public boolean update(Faculty faculty) {
		// TODO Auto-generated method stub
	    try{
	    	entityManager.getTransaction().begin();
	        entityManager.merge(faculty);
	        entityManager.getTransaction().commit();
	        return true;
	     } catch(Exception ex) {
	         return false;
	     }
	}
	

}
