package org.unitedpro.mumsched.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "Entry")
public class Entry {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long entry_id;
	
	@NotEmpty
	@Column(name = "entryname")
	private String entryName;
	
    @Column(name = "number_of_FPPs")
    private int noFPP;

    @Column(name = "number_of_MPPs")
    private int noMPP;

    @Column(name = "number_of_OPT_FPPs")
    private int noOPTFPP;

    @Column(name = "number_of_OPT_MPPs")
    private int noOPTMPP;
    
    @Column(name = "number_of_USResidents")
    private int noOfUSRes;

    @OneToMany(mappedBy = "entry")
    private List<Block> blocks;

	public long getEntry_id() {
		return entry_id;
	}

	public void setEntry_id(long entry_id) {
		this.entry_id = entry_id;
	}

	public String getEntryName() {
		return entryName;
	}

	public void setEntryName(String entryName) {
		this.entryName = entryName;
	}

	public int getNoFPP() {
		return noFPP;
	}

	public void setNoFPP(int noFPP) {
		this.noFPP = noFPP;
	}

	public int getNoMPP() {
		return noMPP;
	}

	public void setNoMPP(int noMPP) {
		this.noMPP = noMPP;
	}

	public int getNoOPTFPP() {
		return noOPTFPP;
	}

	public void setNoOPTFPP(int noOPTFPP) {
		this.noOPTFPP = noOPTFPP;
	}

	public int getNoOPTMPP() {
		return noOPTMPP;
	}

	public void setNoOPTMPP(int noOPTMPP) {
		this.noOPTMPP = noOPTMPP;
	}

	public int getNoOfUSRes() {
		return noOfUSRes;
	}

	public void setNoOfUSRes(int noOfUSRes) {
		this.noOfUSRes = noOfUSRes;
	}

	public List<Block> getBlocks() {
		return blocks;
	}

	public void setBlocks(List<Block> blocks) {
		this.blocks = blocks;
	}
    
}
