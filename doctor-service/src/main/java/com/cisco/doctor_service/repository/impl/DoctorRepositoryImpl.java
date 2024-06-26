package com.cisco.doctor_service.repository.impl;

import com.cisco.doctor_service.model.Doctor;
import com.cisco.doctor_service.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class DoctorRepositoryImpl implements DoctorRepository {

    private final JdbcClient jdbcClient;

    @Override
    public Integer addDoctor(Doctor doctor) {
        return 0;
    }

    @Override
    public List<Doctor> getAllDoctors() {
        return List.of();
    }

    @Override
    public Integer getDoctorsCount() {
        return 0;
    }

    @Override
    public Doctor getDoctorById(String id) {
        return null;
    }

    @Override
    public Integer updateDoctor(String id, Doctor doctor) {
        return 0;
    }

    @Override
    public Integer deleteDoctor(String id) {
        return 0;
    }
}
