//package org.unitedpro.mumsched.domain;
//
//import java.util.List;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.OneToMany;
//import javax.persistence.Table;
//
//@Entity
//@Table(name = "Faculty")
//public class Schedule {
//	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
//	private long schedule_id;
//	
//	@OneToMany(mappedBy = "schedule")
//	private List<Entry> entrys;
//
//	public List<Entry> getEntrys() {
//		return entrys;
//	}
//
//	public void addEntry(Entry entry) {
//		entrys.add(entry);
//	}
//}
