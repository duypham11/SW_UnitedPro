package org.unitedpro.mumsched.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.unitedpro.mumsched.dao.EntryDAO;
import org.unitedpro.mumsched.domain.Entry;

public class ScheduleServiceImpl implements IScheduleService {
	@Autowired
	private EntryDAO entryDAO;
	
	@Override
	public Entry findEntryById(long entryId) {
		return entryDAO.findOne(entryId);
	}

	@Override
	public boolean generateSchedule(long entryId) {

		return false;
	}

	@Override
	public boolean readSchedule(long entryId) {

		return false;
	}

	@Override
	public boolean deleteSchedule(long entryId) {

		return false;
	}

}
