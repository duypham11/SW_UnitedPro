package org.unitedpro.mumsched.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.unitedpro.mumsched.domain.Section;

@Repository
public interface SectionDAO extends CrudRepository<Section, Long> {
	
}
