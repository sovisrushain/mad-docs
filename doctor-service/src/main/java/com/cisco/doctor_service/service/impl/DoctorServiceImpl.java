package com.cisco.doctor_service.service.impl;

import com.cisco.doctor_service.model.Doctor;
import com.cisco.doctor_service.repository.DoctorRepository;
import com.cisco.doctor_service.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;

    @Override
    public Integer addDoctor(Doctor doctor) {
        return doctorRepository.addDoctor(doctor);
    }

    @Override
    public List<Doctor> getAllDoctors() {
        return doctorRepository.getAllDoctors();
    }

    @Override
    public Integer getDoctorsCount() {
        return doctorRepository.getDoctorsCount();
    }

    @Override
    public Doctor getDoctorById(String id) {
        return doctorRepository.getDoctorById(id);
    }

    @Override
    public Integer updateDoctor(String id, Doctor doctor) {
        return doctorRepository.updateDoctor(id, doctor);
    }

    @Override
    public Integer deleteDoctor(String id) {
        return doctorRepository.deleteDoctor(id);
    }
}
