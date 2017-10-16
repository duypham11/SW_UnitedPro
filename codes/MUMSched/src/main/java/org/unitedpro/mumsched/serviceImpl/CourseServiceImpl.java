package org.unitedpro.mumsched.serviceImpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.unitedpro.mumsched.domain.Course;
import org.unitedpro.mumsched.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService{

	//private Course course;
	private EntityManager entityManager;
	
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
	    this.entityManager = entityManager;
	}
	public EntityManager getEntityManager() {
	    return entityManager;
	}
	@Override
	public void save(Course course) {
		// TODO Auto-generated method stub
		entityManager.getTransaction().begin();
		entityManager.persist(course);
		
		//entityManager.flush();
		entityManager.getTransaction().commit();
	}

	@Override
	public Course getCourseById(Long id) {
		// TODO Auto-generated method stub
		return entityManager.find(Course.class, id);
	}

	@Override
	public boolean delete(Course course) {
		// TODO Auto-generated method stub
		try {
			entityManager.getTransaction().begin();
	         entityManager.remove(course);
	         entityManager.getTransaction().commit();
	    } catch (Exception ex) {
	        return false;
	    }
	    return true;
	}

	@Override
	public boolean update(Course course) {
		// TODO Auto-generated method stub
	    try{
	    	entityManager.getTransaction();
	        entityManager.merge(course);
	        entityManager.getTransaction().commit();
	        return true;
	     } catch(Exception ex) {
	         return false;
	     }
	}
	

}
