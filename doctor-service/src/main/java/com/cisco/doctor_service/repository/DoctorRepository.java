package com.cisco.doctor_service.repository;

import com.cisco.doctor_service.model.Doctor;

import java.util.List;

public interface DoctorRepository {
    Integer addDoctor(Doctor doctor);
    List<Doctor> getAllDoctors();
    Integer getDoctorsCount();
    Doctor getDoctorById(String id);
    Integer updateDoctor(String id, Doctor doctor);
    Integer deleteDoctor(String id);
}
