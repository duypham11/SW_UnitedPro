package org.unitedpro.mumsched.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.unitedpro.mumsched.domain.Entry;

@Repository
public interface EntryDAO extends  CrudRepository <Entry, Long>{
	@Query( "select e from Entry e" )
	List<Entry> getEntryList();
}
