package org.unitedpro.mumsched.serviceImpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.unitedpro.mumsched.domain.Section;
import org.unitedpro.mumsched.service.SectionService;

@Service
public class SectionServiceImpl implements SectionService{

	//private Section section;
	private EntityManager entityManager;
	
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
	    this.entityManager = entityManager;
	}
	public EntityManager getEntityManager() {
	    return entityManager;
	}
	@Override
	public void save(Section section) {
		// TODO Auto-generated method stub
		entityManager.persist(section);
		//entityManager.flush();
	}

	@Override
	public Section getSectionById(Long id) {
		// TODO Auto-generated method stub
		return entityManager.find(Section.class, id);
	}

	@Override
	public boolean delete(Section section) {
		// TODO Auto-generated method stub
		try {
	         entityManager.remove(section);
	    } catch (Exception ex) {
	        return false;
	    }
	    return true;
	}

	@Override
	public boolean update(Section section) {
		// TODO Auto-generated method stub
	    try{
	    	entityManager.getTransaction().begin();
	        entityManager.merge(section);
	        entityManager.getTransaction().commit();
	        return true;
	     } catch(Exception ex) {
	         return false;
	     }
	}
	

}
