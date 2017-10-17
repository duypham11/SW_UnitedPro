package org.unitedpro.mumsched.dao;

import org.springframework.data.repository.CrudRepository;
import org.unitedpro.mumsched.domain.Student_Section;

public interface StudentSectionDAO extends CrudRepository<Student_Section, Long> {
    Iterable<Student_Section> getAllByStudent();
}
