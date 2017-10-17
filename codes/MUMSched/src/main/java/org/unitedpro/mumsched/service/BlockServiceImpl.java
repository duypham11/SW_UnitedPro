package org.unitedpro.mumsched.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.unitedpro.mumsched.dao.BlockDAO;
import org.unitedpro.mumsched.domain.Block;

import javax.persistence.EntityManager;

@Service
public class BlockServiceImpl implements IBlockService {
	@Autowired
	private BlockDAO blockDAO;

	@Override
	public void save(Block block){
		blockDAO.save(block);
	}

	@Override
	public Block getBlockById(Long id){
		return blockDAO.findOne(id);
	}

	@Override
	public boolean delete(Block block){
		 blockDAO.delete(block);
		 return true;
	}

	@Override
	public boolean update(Block block){
		blockDAO.save(block);
		return true;
	}
}
