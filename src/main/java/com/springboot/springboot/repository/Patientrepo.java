package com.springboot.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.springboot.entities.Patient;

@Repository
public interface Patientrepo extends JpaRepository<Patient, Integer> {

	Patient findByName(String department);


}
