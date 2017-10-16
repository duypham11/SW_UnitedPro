package org.unitedpro.mumsched.service;

import javax.persistence.EntityManager;

import org.unitedpro.mumsched.domain.Block;

public interface BlockService {
	public void setEntityManager(EntityManager entityManager);
	public EntityManager getEntityManager();
	public void save(Block block);
	public Block getBlockById(Long id);
	public boolean delete(Block block);
	public boolean update(Block block);
}
