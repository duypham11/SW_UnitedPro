package org.unitedpro.mumsched.service;

import org.unitedpro.mumsched.domain.Faculty;

/**
 * Created by Duong Truong on 10/17/2017.
 */
public interface IFacultyService {
    void save(Faculty faculty);

    Faculty getFacultyById(Long id);

    Iterable<Faculty> getAllFaculty();

    boolean delete(Faculty faculty);

    boolean update(Faculty faculty);
}
