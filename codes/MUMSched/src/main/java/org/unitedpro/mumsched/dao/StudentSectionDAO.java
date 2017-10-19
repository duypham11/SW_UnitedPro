package org.unitedpro.mumsched.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.unitedpro.mumsched.domain.Section;
import org.unitedpro.mumsched.domain.Student_Section;

@Repository
public interface StudentSectionDAO extends CrudRepository<Student_Section, Long> {
    @Query(value = "select ss.section from Student_Section ss where ss.student.student_id = :id")
   Iterable<Section> getAllByStudent_Student_id(@Param("id") long studentid);
}
