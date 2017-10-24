package org.unitedpro.mumsched.service;

import java.util.List;

import org.unitedpro.mumsched.domain.Entry;

/**
 * Created by Duong Truong on 10/17/2017.
 */
public interface IEntryService {
    void save(Entry entry);

    Entry getEntryById(Long id);

    boolean delete(Entry entry);

    boolean update(Entry entry);

    Iterable<Entry> getAllEntry();    

    List<Entry> getEntryList();
}
