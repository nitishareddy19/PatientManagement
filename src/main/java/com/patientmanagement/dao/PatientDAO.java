package com.patientmanagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.patientmanagement.model.Patient;

@Repository
public class PatientDAO {
	public Patient savePatient(Patient patient) {

		String INSERT_USERS_SQL = "INSERT INTO tbl_patient"
				+ "  (first_name, middle_name, last_name, phonenumber, email) VALUES " + " ('" + patient.getFirstName()
				+ "','" + patient.getMiddleName() + "','" + patient.getLastName() + "'," + patient.getPhoneNumber()
				+ ",'" + patient.getEmail() + "')";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/patientdb", "root", "Admin123");
			Statement stmt = con.createStatement();
			int result = stmt.executeUpdate(INSERT_USERS_SQL);
			con.close();
		} catch (ClassNotFoundException e)

		{
			System.out.println(e);
		} catch (SQLException se) {
			System.out.println(se);
		}

		return patient;
	}

	public Patient updatePatient(Patient patient) {

		return patient;
	}

	public String deletePatientById(long patientId) {
		return "successfully Deleted";
	}

	public Patient getPatientById(long patientId) {
		Patient patient = new Patient();
		patient.setId(patientId);
		patient.setFirstName("abc");
		patient.setMiddleName("snd");
		patient.setLastName("def");
		patient.setPhoneNumber(9000001);
		patient.setEmail("abc@gmail.com");
		return patient;
	}

	public List<Patient> getPatients() {
		List<Patient> patients = new ArrayList<Patient>();
		Patient patient1 = new Patient();
		patient1.setId(2);
		patient1.setFirstName("abc");
		patient1.setMiddleName("snd");
		patient1.setLastName("def");
		patient1.setPhoneNumber(9000001);
		patient1.setEmail("abc@gmail.com");
		Patient patient2 = new Patient();
		patient2.setId(3);
		patient2.setFirstName("abc");
		patient2.setMiddleName("snd");
		patient2.setLastName("def");
		patient2.setPhoneNumber(9000001);
		patient2.setEmail("abc@gmail.com");
		patients.add(patient1);
		patients.add(patient2);
		return patients;

	}

}
