package com.springboot.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.springboot.entities.Patient;
import com.springboot.springboot.repository.Patientrepo;


@Service
public class PatientService {

	@Autowired
	private Patientrepo patientrepo;
	
     public List<Patient> getAppointments() {
		
		return patientrepo.findAll();
	} 


	public Patient getAppointment(int id) {
		// TODO Auto-generated method stub
		return patientrepo.findById(id).get();
	}


	public Patient getAppointmentDetails(String did) {
		// TODO Auto-generated method stub
		return patientrepo.findByName(did);
	}
	public void saveAppointement(Patient appointment) {
		this.patientrepo.save(appointment);
	}
	
	public void deleteAppointment(int id) {
		Patient d=patientrepo.findById(id).get();
		patientrepo.delete(d);
	}

	public String deleteDoctor(int id) {
		// TODO Auto-generated method stub
		Patient e=patientrepo.findById(id).get();
		patientrepo.delete(e);
		return "Successfully deleted details of Appointment";
	}
}
