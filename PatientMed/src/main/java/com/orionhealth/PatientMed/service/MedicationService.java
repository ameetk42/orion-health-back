package com.orionhealth.PatientMed.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orionhealth.PatientMed.entity.Medication;
import com.orionhealth.PatientMed.repo.MedicationRepository;

@Service
public class MedicationService {
	
	@Autowired
	MedicationRepository medicationRepository;
	
	

	public List<Medication> getAllMedications() {
		return medicationRepository.findAll();
	}

	
	public void deleteMedication(long med_id) {
		// TODO Auto-generated method stub
		
	}

	public Medication saveMedication(Medication medication) {
		return medicationRepository.save(medication);
		
	}


	public Optional<Medication> findById(Integer med_id) {
		return medicationRepository.findById(med_id);
		 
	}


	public void delete(Medication medication) {
		medicationRepository.delete(medication);
		
	}

}
