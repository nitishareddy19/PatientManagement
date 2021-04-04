package com.patientmanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patientmanagement.dao.PatientDAO;
import com.patientmanagement.model.Patient;

@Service
public class PatientService {
	
	@Autowired
	PatientDAO dao;
	
	public Patient createPatient(Patient patient) {
		Patient p = dao.savePatient(patient);
		
		return p;
	}

	public Patient updatePatient(Patient patient) {
		Patient p = dao.updatePatient(patient);

		return p;
	}

	public String deletePatientById(long patientId) {
		return dao.deletePatientById(patientId);
	
	}

	public Patient getPatientById(long patientId) {
		Patient p = dao.getPatientById(patientId);
		return p;
	}

	public List<Patient> getPatients() {
		return dao.getPatients();
	

	}

}
