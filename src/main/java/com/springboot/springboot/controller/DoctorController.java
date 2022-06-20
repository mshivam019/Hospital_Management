package com.springboot.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.springboot.springboot.entities.Doctor;
import com.springboot.springboot.service.DoctorService;


@Controller
public class DoctorController {
	
	@Autowired
	private DoctorService eservice;
	

	
	// display list of patients
		@GetMapping("/dpatient")
		public String dpatient(Model model) {
			model.addAttribute("listDoctor",eservice.getAllPatients());
			return "dpatient";
		}
		@GetMapping("/showNewPatientForm")
		public String showNewPatientForm(Model model) {
			// create model attribute to bind form data
			Doctor doctor = new Doctor();
			model.addAttribute("doctor", doctor);
			return "new_patient";
		}
		
		@PostMapping("/savePatient")
		public String savePatient(@ModelAttribute("doctor") Doctor doctor) {
			eservice.savePatient(doctor);
			return "redirect:/dpatient";
		}
		
		@GetMapping("/showFormForUpdate/{id}")
		public String showFormForUpdate(@PathVariable ( value = "id") int id, Model model) {
			
			// get patient from the service
			Doctor doctor = eservice.getPatientById(id);
			
			// set patient as a model attribute to pre-populate the form
			model.addAttribute("doctor", doctor);
			return "update_patient";
		}
		
		@GetMapping("/deletePatient/{id}")
		public String deletePatient(@PathVariable (value = "id") int id) {
			
			// call delete patient method 
			this.eservice.deletePatientById(id);
			return "redirect:/dpatient";
		}
		

}
