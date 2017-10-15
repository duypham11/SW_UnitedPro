package org.unitedpro.mumsched.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.unitedpro.mumsched.domain.*;

public interface BlockDAO extends  CrudRepository <Block, Long>{
	@Query("select b from Block b where b.blockName = :blockName")
	public Entry findBlockByName(@Param("blockName") String blockName);
	
	@Query("select b from Block b where b.block_id = :blockId")
	public Entry findBlockById(@Param("blockId") Long blockId);
}
