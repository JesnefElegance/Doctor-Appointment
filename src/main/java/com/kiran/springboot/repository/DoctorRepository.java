package com.kiran.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kiran.springboot.model.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Integer>{

}
