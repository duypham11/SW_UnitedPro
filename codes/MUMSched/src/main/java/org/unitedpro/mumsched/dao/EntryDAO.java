package org.unitedpro.mumsched.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.unitedpro.mumsched.domain.Entry;

@Repository
public interface EntryDAO extends  CrudRepository <Entry, Long>{
}
