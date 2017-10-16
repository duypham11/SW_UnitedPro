package org.unitedpro.mumsched.service;

import org.unitedpro.mumsched.domain.Section;

public interface SectionService {
	public void save(Section section);
	public Section getSectionById(Long id);
	public boolean delete(Section section);
	public Section update(Section section);
}
