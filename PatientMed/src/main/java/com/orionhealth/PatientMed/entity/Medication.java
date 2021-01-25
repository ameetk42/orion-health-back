package com.orionhealth.PatientMed.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;;

@Entity
public class Medication {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int med_id;
	private String name;
	private String desc;

	@OneToMany (mappedBy="medication")
	//private DateMedication dateMedications;
	private Set<DateMedication> dateMedications = new HashSet<DateMedication>();

	public String getName() {
		return name;
	}

	public int getMed_id() {
		return med_id;
	}

	public void setMed_id(int med_id) {
		this.med_id = med_id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Set<DateMedication> getDateMedications() {
		return dateMedications;
	}

	public void setDateMedications(Set<DateMedication> dateMedications) {
		this.dateMedications = dateMedications;
	}

	
	@Override
    public String toString() {
        return "Medication [id=" + med_id + ", name=" + name + ", Desc=" + "]";
    }


}
