package org.unitedpro.mumsched.service;

import org.unitedpro.mumsched.domain.Section;

/**
 * Created by Duong Truong on 10/17/2017.
 */
public interface ISectionService {
    void save(Section section);

    Section getSectionById(Long id);

    Iterable<Section> getAllSection();

    boolean delete(Section section);

    boolean update(Section section);
}
