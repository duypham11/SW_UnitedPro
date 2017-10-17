/*package org.unitedpro.mumsched.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.unitedpro.mumsched.domain.*;

public interface EntryDAO extends  CrudRepository <Entry, Long>{
	@Query("select e from Entry e where e.entryName = :entryName")
	public Entry findEntryByName(@Param("entryName") String entryName);
	
	@Query("select e from Entry e where e.entry_id = :entryId")
	public Entry findEntryById(@Param("entryId") Long entryId);
}
*/