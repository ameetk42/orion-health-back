package com.orionhealth.PatientMed.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.orionhealth.PatientMed.entity.DateMedication;
import com.orionhealth.PatientMed.entity.Medication;
import com.orionhealth.PatientMed.exception.ResourceNotFoundException;
import com.orionhealth.PatientMed.service.MedicationService;

@RestController @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class MedicationController {

	@Autowired
	MedicationService medicationService;

	@GetMapping("/medication")
	public List<Medication> getAllMedications() {

		return medicationService.getAllMedications();
	}// getAllMedications


	   @GetMapping("/medication/{id}")
	    public ResponseEntity<Medication> getMedicationById(@PathVariable(value = "id") Integer med_id)
	        throws ResourceNotFoundException {
		   Medication medication = medicationService.findById(med_id)
	          .orElseThrow(() -> new ResourceNotFoundException("Medication not found for this id :: " + med_id));
	        return ResponseEntity.ok().body(medication);
	    }
	
	
	   @PostMapping("/medication")
	    public Medication createMedication(@Valid @RequestBody Medication medication) {
	        return medicationService.saveMedication(medication);
	    }
	   
	   
	   @PutMapping("/medication/{id}")
	    public ResponseEntity<Medication> updateMedication(@PathVariable(value = "id") Integer med_id,
	         @Valid @RequestBody Medication medicationDetails) throws ResourceNotFoundException {
		   Medication medication = medicationService.findById(med_id)
	        .orElseThrow(() -> new ResourceNotFoundException("Medication not found for this id :: " + med_id));

	        medication.setName(medicationDetails.getName());
	        medication.setDesc(medicationDetails.getDesc());
	        medication.setDateMedications(medicationDetails.getDateMedications());
	        final Medication updatedMedication= medicationService.saveMedication(medication);
	        return ResponseEntity.ok(updatedMedication);
	    }
	
	
	   
	   
	   @DeleteMapping("/medication/{id}")
	    public Map<String, Boolean> deleteMedication(@PathVariable(value = "id") Integer med_Id)
	         throws ResourceNotFoundException {
		   Medication medication = medicationService.findById(med_Id)
	       .orElseThrow(() -> new ResourceNotFoundException("Medication not found for this id :: " + med_Id));

		   medicationService.delete(medication);
	        Map<String, Boolean> response = new HashMap<>();
	        response.put("deleted", Boolean.TRUE);
	        return response;
	    }
	   
	   
	   
	
	
	
	@RequestMapping(value = "/delete-medication", method = RequestMethod.GET)
	public String deleteMedication(@RequestParam long med_id) {
		medicationService.deleteMedication(med_id);
		// service.deleteTodo(id);
		return "redirect:/list-todos";
	}

}
