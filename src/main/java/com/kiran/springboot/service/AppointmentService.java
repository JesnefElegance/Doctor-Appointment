package com.kiran.springboot.service;

import org.springframework.http.ResponseEntity;

import com.kiran.springboot.model.Appointment;
import com.kiran.springboot.model.Patient;
import com.kiran.springboot.util.ResponseStructure;

public interface AppointmentService {

	ResponseEntity<ResponseStructure<Appointment>> appointPatient(Patient patient);

}
