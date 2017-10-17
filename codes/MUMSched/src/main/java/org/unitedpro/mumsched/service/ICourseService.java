package org.unitedpro.mumsched.service;

import org.unitedpro.mumsched.domain.Course;

/**
 * Created by Duong Truong on 10/17/2017.
 */
public interface ICourseService {
    void save(Course course);

    Course getCourseById(Long id);

    boolean delete(Course course);

    boolean deleteById(long id);

    boolean update(Course course);
}
