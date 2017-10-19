package org.unitedpro.mumsched.service;

import org.unitedpro.mumsched.domain.Entry;

public interface IScheduleService {
	Entry findEntryById(long entryId);
	boolean generateSchedule(long entryId);
	boolean readSchedule(long entryId);
	boolean deleteSchedule(long entryId);
}
