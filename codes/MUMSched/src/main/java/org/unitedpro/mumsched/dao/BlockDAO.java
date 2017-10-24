package org.unitedpro.mumsched.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.unitedpro.mumsched.domain.Block;

@Repository
public interface BlockDAO extends CrudRepository <Block, Long>{
	@Query( "select b from Block b" )
	List<Block> getBlockList();
}
