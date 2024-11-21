package com.kiran.springboot.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.kiran.springboot.exception.DoctorNotAvailableException;
import com.kiran.springboot.model.Appointment;
import com.kiran.springboot.model.Doctor;
import com.kiran.springboot.model.Patient;
import com.kiran.springboot.repository.AppointmentRepository;
import com.kiran.springboot.repository.DoctorRepository;
import com.kiran.springboot.repository.PatientRepository;
import com.kiran.springboot.service.AppointmentService;
import com.kiran.springboot.util.ResponseStructure;

@Service
public class AppointmentServiceImpl implements AppointmentService {

	@Autowired
	private DoctorRepository docRepo;
	@Autowired
	private AppointmentRepository appRepo;
	@Autowired
	private PatientRepository patRepo;
	
	@Override
	public ResponseEntity<ResponseStructure<Appointment>> appointPatient(Patient patient) {
		
		List<Doctor> doctors = docRepo.findAll();
		
		for(Doctor doctor: doctors) {
			
			if(doctor.getServiceTime()<=20 && doctor.getDiseaseConsult().equals(patient.getPatientDisease())) {
				
				doctor.setServiceTime(doctor.getServiceTime()-20);
				
				patRepo.save(patient);
				docRepo.save(doctor);
				
				Appointment app = new Appointment();
				app.setDoctor(doctor);
				app.setPatient(patient);
				app.setScheduleTime(doctor.getScheduleTime());
				appRepo.save(app);
				
				ResponseStructure<Appointment> st = new ResponseStructure<Appointment>(); 
				st.setStatuscode(HttpStatus.CREATED.value())
				  .setMessage("Your appointment is added at"+doctor.getScheduleTime())
				  .setData(app);
				
				return ResponseEntity.status(HttpStatus.CREATED).body(st);
			}
		}
		
		throw new DoctorNotAvailableException("The Doctor you are looking for is not available");
	}

}
