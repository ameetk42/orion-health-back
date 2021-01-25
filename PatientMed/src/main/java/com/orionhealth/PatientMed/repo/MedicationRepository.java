package com.orionhealth.PatientMed.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orionhealth.PatientMed.entity.Medication;

public interface MedicationRepository extends JpaRepository<Medication, Integer>{

}
