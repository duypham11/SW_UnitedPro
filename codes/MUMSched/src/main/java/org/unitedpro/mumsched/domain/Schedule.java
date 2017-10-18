package org.unitedpro.mumsched.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Schedule {
	@OneToMany(mappedBy = "schedule")
	private List<Entry> entrys;

	public List<Entry> getEntrys() {
		return entrys;
	}

	public void addEntry(Entry entry) {
		entrys.add(entry);
	}
}
