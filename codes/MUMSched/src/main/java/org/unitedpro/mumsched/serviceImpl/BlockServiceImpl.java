package org.unitedpro.mumsched.serviceImpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.unitedpro.mumsched.domain.Block;
import org.unitedpro.mumsched.service.BlockService;

@Service
public class BlockServiceImpl implements BlockService{

	//private Block block;
	private EntityManager entityManager;
	
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
	    this.entityManager = entityManager;
	}
	public EntityManager getEntityManager() {
	    return entityManager;
	}
	
	@Override
	public void save(Block block) {
		// TODO Auto-generated method stub
		entityManager.getTransaction().begin();
		entityManager.persist(block);
		//entityManager.flush();	
		entityManager.getTransaction().commit();
	}

	@Override
	public Block getBlockById(Long id) {
		// TODO Auto-generated method stub
		return entityManager.find(Block.class, id);
	}

	@Override
	public boolean delete(Block block) {
		// TODO Auto-generated method stub
		try {
			entityManager.getTransaction().begin();
	        entityManager.remove(block);
	        entityManager.getTransaction().commit();
	    } catch (Exception ex) {
	        return false;
	    }
	    return true;
	}

	@Override
	public boolean update(Block block) {
		// TODO Auto-generated method stub
	    try{
	    	entityManager.getTransaction().begin();
	    	entityManager.merge(block);
	    	entityManager.getTransaction().commit();
	        return true;
	     } catch(Exception ex) {
	         return false;
	     }
	}

}
