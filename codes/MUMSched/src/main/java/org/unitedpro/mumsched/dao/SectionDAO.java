package org.unitedpro.mumsched.dao;

import org.springframework.data.repository.CrudRepository;
import org.unitedpro.mumsched.domain.Section;


public interface SectionDAO extends CrudRepository<Section, Long> {
	
}
