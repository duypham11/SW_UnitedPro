package org.unitedpro.mumsched.service;

import java.util.List;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.unitedpro.mumsched.dao.FacultyDAO;
import org.unitedpro.mumsched.domain.Entry;
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
	public void deleteFacultyById(long id) {
		facultyDAO.delete(id);
	}

	@Override
	public boolean update(Faculty faculty){
		facultyDAO.save(faculty);
		return true;
	}

    @Override
    public void saveFaculty(Faculty faculty, HttpServletRequest request) {
		faculty.setFirstName(request.getParameter("firstName"));
		faculty.setLastName(request.getParameter("lastName"));
		faculty.setPassword(request.getParameter("password"));
		faculty.setEmail(request.getParameter("email"));
		faculty.setDOB(request.getParameter("DOB"));
    }

	@Override
	public Faculty findFacultyByEmail(String email) {
		return facultyDAO.findFacultyByEmail(email);
	}

    
    @Override
	public List<Faculty> getFacultyList() {
		return facultyDAO.getFacultyList();
	}	
}
