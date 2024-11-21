package com.kiran.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kiran.springboot.model.Appointment;
import com.kiran.springboot.model.Patient;
import com.kiran.springboot.service.AppointmentService;
import com.kiran.springboot.util.ResponseStructure;

@RestController
public class AppointmentController {
	
	@Autowired
	private AppointmentService service;

	@PostMapping("/appointPatient")
	public ResponseEntity<ResponseStructure<Appointment>> appointPatient(@RequestBody Patient patient) {
		return service.appointPatient(patient);
	}
}
