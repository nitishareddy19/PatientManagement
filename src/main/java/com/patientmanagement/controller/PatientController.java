package com.patientmanagement.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.patientmanagement.model.Patient;
import com.patientmanagement.service.PatientService;

@RestController
public class PatientController {
	@Autowired
	PatientService service;

	@PostMapping(path = "/patient/create")
	public Patient createPatient(@RequestBody Patient patient) {
		Patient p = service.createPatient(patient);
		return p;
	}

	@PutMapping(path = "/patient/update")
	public Patient updatePatient(@RequestBody Patient patient) {
		Patient p = service.updatePatient(patient);
			return p;
	}

	@DeleteMapping(path = "/patient/{patientId}")
	public String deletePatientById(@PathVariable long patientId) {
		return service.deletePatientById(patientId);
	}

	@GetMapping(path = "/patient/{patientId}")
	public Patient getPatientById(@PathVariable long patientId) {
		Patient patient = service.getPatientById(patientId);
		return patient;
	}

	@GetMapping(path = "/patient/getall")
	public List<Patient> getPatients() {
		return service.getPatients();
		

	}

}
