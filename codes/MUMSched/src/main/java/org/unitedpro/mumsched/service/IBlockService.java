package org.unitedpro.mumsched.service;

import org.unitedpro.mumsched.domain.Block;

/**
 * Created by Duong Truong on 10/17/2017.
 */
public interface IBlockService {
    void save(Block block);

    Block getBlockById(Long id);

    boolean delete(Block block);

    boolean update(Block block);
}
