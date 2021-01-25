package com.orionhealth.PatientMed.entity;

import java.sql.Date;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class DateMedication {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Basic
	private Date date_taken;
	@ManyToOne (targetEntity = Medication.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "med_id")
	private Medication medication;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate_taken() {
		return date_taken;
	}

	public void setDate_taken(Date date_taken) {
		this.date_taken = date_taken;
	}

	public Medication getMedication() {
		return medication;
	}

	public void setMedication(Medication medication) {
		this.medication = medication;
	}

}
