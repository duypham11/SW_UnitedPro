package org.unitedpro.mumsched.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "Block")
public class Block {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long block_id;
	
	@NotEmpty
	@Column
	private String blockName;
	
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "Block_Section",
            joinColumns = @JoinColumn(name = "block_id"),
            inverseJoinColumns = @JoinColumn(name = "section_id")
    )
    private List<Section> sections;

    @ManyToOne
    private Entry entry;

    @Column
    //@Temporal(TemporalType.DATE)
    private String startDate;

    @Column
    //@Temporal(TemporalType.DATE)
    private String endDate;

    //public Block(String name, Date sDate, Date eDate, )
	public long getBlock_id() {
		return block_id;
	}

	public void setBlock_id(long block_id) {
		this.block_id = block_id;
	} 
	public String getBlockName() {
		return blockName;
	}

	public void setBlockName(String blockName) {
		this.blockName = blockName;
	}

	public Entry getEntry() {
		return entry;
	}

	public void setEntry(Entry entry) {
		this.entry = entry;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public List<Section> getSections() {
		return sections;
	}
}
