package org.unitedpro.mumsched.service;
import org.unitedpro.mumsched.domain.*;

public interface StudentService {
	public void save(Student student);
	public Student getStudentById(Long id);
	public void delete(Student student);
	public void update(Long id, Student student);
}
