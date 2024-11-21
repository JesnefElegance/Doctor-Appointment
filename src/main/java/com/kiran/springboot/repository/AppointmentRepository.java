package com.kiran.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kiran.springboot.model.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

}
