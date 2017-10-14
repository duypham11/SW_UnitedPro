package org.unitedpro.mumsched.service;
import org.unitedpro.mumsched.domain.*;

public interface StudentService {
	public void save(Student student);
	public Student getStudentById(Long id);
}
