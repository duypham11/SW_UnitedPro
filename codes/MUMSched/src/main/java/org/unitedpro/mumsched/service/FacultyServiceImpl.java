package org.unitedpro.mumsched.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.unitedpro.mumsched.dao.FacultyDAO;
import org.unitedpro.mumsched.domain.Faculty;
@Service
public class FacultyServiceImpl implements IFacultyService {
	@Autowired
	private FacultyDAO facultyDAO;

	@Override
	public void save(Faculty faculty){
		facultyDAO.save(faculty);
	}

	@Override
	public Faculty getFacultyById(Long id){
		return facultyDAO.findOne(id);
	}

	@Override
	public Iterable<Faculty> getAllFaculty(){
		return facultyDAO.findAll();
	}

	@Override
	public boolean delete(Faculty faculty){
		facultyDAO.delete(faculty);
		return true;
	}

	@Override
	public boolean update(Faculty faculty){
		facultyDAO.save(faculty);
		return true;
	}
}
