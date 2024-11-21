package com.kiran.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kiran.springboot.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer> {

}
