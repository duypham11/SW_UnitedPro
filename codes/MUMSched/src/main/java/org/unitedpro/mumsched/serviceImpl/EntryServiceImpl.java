package org.unitedpro.mumsched.serviceImpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.unitedpro.mumsched.domain.Entry;

@Service
public class EntryServiceImpl implements EntryService {

	//private Entry entry;
	private EntityManager entityManager;
	
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
	    this.entityManager = entityManager;
	}
	public EntityManager getEntityManager() {
	    return entityManager;
	}
	@Override
	public void save(Entry entry) {
		// TODO Auto-generated method stub
		entityManager.getTransaction().begin();
		entityManager.persist(entry);
		//entityManager.flush();
		entityManager.getTransaction().commit();
	}

	@Override
	public Entry getEntryById(Long id) {
		// TODO Auto-generated method stub
		return entityManager.find(Entry.class, id);
	}

	@Override
	public boolean delete(Entry entry) {
		// TODO Auto-generated method stub
		try {
			entityManager.getTransaction().begin();
	        entityManager.remove(entry);
	        entityManager.getTransaction().commit();
	    } catch (Exception ex) {
	        return false;
	    }
	    return true;
	}

	@Override
	public boolean update(Entry entry) {
		// TODO Auto-generated method stub
	    try{
	    	entityManager.getTransaction().begin();
	        entityManager.merge(entry);
	        entityManager.getTransaction().commit();
	        return true;
	     } catch(Exception ex) {
	         return false;
	     }
	}
	

}
