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
	@Column(name = "entryName")
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
}
