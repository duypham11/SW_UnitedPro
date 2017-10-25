package org.unitedpro.mumsched.service;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.unitedpro.mumsched.domain.Faculty;

/**
 * Created by Duong Truong on 10/17/2017.
 */
public interface IFacultyService {
    void save(Faculty faculty);

    Faculty getFacultyById(Long id);

    Iterable<Faculty> getAllFaculty();

    boolean delete(Faculty faculty);

    void deleteFacultyById(long id);

    boolean update(Faculty faculty);

    void saveFaculty(Faculty student, HttpServletRequest request);

    Faculty findFacultyByEmail(String email);
}
