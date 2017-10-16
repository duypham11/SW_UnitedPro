package org.unitedpro.mumsched.service;

import org.unitedpro.mumsched.domain.Faculty;

public interface FacultyService {
	public void save(Faculty faculty);
	public Faculty getFacultyById(Long id);
	public boolean delete(Faculty faculty);
	public Faculty update(Faculty faculty);
}
