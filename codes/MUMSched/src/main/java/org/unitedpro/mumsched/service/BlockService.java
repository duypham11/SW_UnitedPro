package org.unitedpro.mumsched.service;

import org.unitedpro.mumsched.domain.Block;

public interface BlockService {
	public void save(Block block);
	public Block getBlockById(Long id);
	public boolean delete(Block block);
	public Block update(Block block);
}
