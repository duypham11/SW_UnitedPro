package org.unitedpro.mumsched.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.unitedpro.mumsched.domain.Section;

@Repository
public interface SectionDAO extends CrudRepository<Section, Long> {
	@Query( "select s from Section s" )
	List<Section> getSectionList();	
}
