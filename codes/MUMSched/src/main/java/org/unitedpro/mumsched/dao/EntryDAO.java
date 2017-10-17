package org.unitedpro.mumsched.dao;

import org.springframework.data.repository.CrudRepository;
import org.unitedpro.mumsched.domain.Entry;

public interface EntryDAO extends  CrudRepository <Entry, Long>{
}
