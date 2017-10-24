package org.unitedpro.mumsched.service;

import java.util.List;

import org.unitedpro.mumsched.domain.Block;
import org.unitedpro.mumsched.domain.Entry;

/**
 * Created by Duong Truong on 10/17/2017.
 */
public interface IBlockService {
    void save(Block block);

    Block getBlockById(Long id);

    boolean delete(Block block);

    boolean update(Block block);

    Iterable<Block> getAllBlock();
    
    List<Block> getBlockList();

}
