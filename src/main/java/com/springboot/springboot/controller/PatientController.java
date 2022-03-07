package com.springboot.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.springboot.springboot.entities.Patient;
import com.springboot.springboot.service.PatientService;


@Controller
public class PatientController {
		
	@Autowired
	private PatientService dservice;
	@GetMapping("/appointment")
	public String appointment(Model model) {
		model.addAttribute("list",dservice.getAppointments());
		return "appointment";
	}
	@GetMapping("/showNewAppointmentForm")
	public String showNewAppointmentForm(Model model) {
		// create model attribute to bind form data
		Patient patient=new Patient();
		model.addAttribute("patient", patient);
		return "new_appointment";
	}
	
	@PostMapping("/saveappointment")
	public String saveAppointment(@ModelAttribute("patient") Patient patient) {
		// save appointment to database
		dservice.saveAppointement(patient);
		return "redirect:appointment";
	}
	
	@GetMapping("/appointmentUpdate/{id}")
	public String showFormForUpdate(@PathVariable ( value = "id") int id, Model model) {
		
		// get appointment from the service
		Patient patient = dservice.getAppointment(id);
		model.addAttribute("patient", patient);
		return "update_appointment";
	}
	
	@GetMapping("/deleteappointment/{id}")
	public String deleteAppointment(@PathVariable (value = "id") int id) {
		
		// call delete employee method 
		this.dservice.deleteAppointment(id);
		return "redirect:/appointment";
	}
}
