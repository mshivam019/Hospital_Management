package com.springboot.springboot.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springboot.springboot.entities.Doctor;
import com.springboot.springboot.repository.DoctorRepo;

/*import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;*/

@Service
public class DoctorService{

	@Autowired
	private DoctorRepo drepo;
	
	public List<Doctor> getAllPatients() {
		// TODO Auto-generated method stub
		return drepo.findAll();
	}
	
	public void savePatient(Doctor patient) {
		this.drepo.save(patient);
	}

	public Doctor getPatientById(int id) {
		return drepo.findById(id).get();
	}

	public void deletePatientById(int id) {
		Doctor e=drepo.findById(id).get();
		drepo.delete(e);
	}
}
