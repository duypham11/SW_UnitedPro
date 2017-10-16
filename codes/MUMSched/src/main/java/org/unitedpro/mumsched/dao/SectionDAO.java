/*package org.unitedpro.mumsched.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.unitedpro.mumsched.domain.*;


public interface SectionDAO extends  CrudRepository<Section, Long> {
	@Query("select s from Section s where s.sectionName = :sectionName")
	public Entry findSectionByName(@Param("sectionName") String sectionName);
	
	@Query("select s from Section s where s.section_id = :sectionId")
	public Entry findSectionById(@Param("sectionId") Long sectionId);
	
}
*/