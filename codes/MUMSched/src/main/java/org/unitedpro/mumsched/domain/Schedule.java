package org.unitedpro.mumsched.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Schedule")
public class Schedule {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private long schedule_id;
	
	private String blockName;
	private Date startDate;
	private Date endDate;
	private String courseName;
	
	@OneToOne(mappedBy = "schedule")
	private Entry entry;

	public Entry getEntry() {
		return entry;
	}

//	public void addEntry(Entry entry) {
//		entrys.add(entry);
//	}

	public String getBlockName() {
		return blockName;
	}

	public void setBlockName(String blockName) {
		this.blockName = blockName;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public long getSchedule_id() {
		return schedule_id;
	}

	public void setEntrys(List<Entry> entrys) {
		this.entrys = entrys;
	}
}
