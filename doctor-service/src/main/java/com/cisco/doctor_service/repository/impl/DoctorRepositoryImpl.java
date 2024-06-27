package com.cisco.doctor_service.repository.impl;

import com.cisco.doctor_service.model.Doctor;
import com.cisco.doctor_service.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class DoctorRepositoryImpl implements DoctorRepository {

    private final JdbcClient jdbcClient;
    private static final Logger log = LoggerFactory.getLogger(DoctorRepositoryImpl.class);

    @Override
    public Integer addDoctor(Doctor doctor) {
        try {
            var sql = "INSERT INTO doctor(doctor_id, doctor_name, doctor_specialization) VALUES (?, ?, ?)";
            return jdbcClient.sql(sql)
                    .param(1, doctor.getDoctorId())
                    .param(2, doctor.getDoctorName())
                    .param(3, doctor.getDoctorSpecialization())
                    .update();
        } catch (Exception ex) {
            log.error("DoctorRepositoryImpl => addDoctor: {}", ex.getMessage());
            return 0;
        }
    }

    @Override
    public List<Doctor> getAllDoctors() {
        try {
            var sql = "SELECT * FROM doctor";
            return jdbcClient.sql(sql)
                    .query(Doctor.class)
                    .list();
        } catch (Exception ex) {
            log.error("DoctorRepositoryImpl => getAllDoctors: {}", ex.getMessage());
            return new ArrayList<>();
        }
    }

    @Override
    public Integer getDoctorsCount() {
        var sql = "SELECT COUNT(*) FROM doctor";
        Optional<Integer> count = jdbcClient.sql(sql)
                .query(Integer.class)
                .optional();
        return count.orElse(0);
    }

    @Override
    public Doctor getDoctorById(String id) {
        try {
            var sql = "SELECT * FROM doctor WHERE doctor_id = ?";
            Optional<Doctor> doctor = jdbcClient.sql(sql)
                    .param(1, id)
                    .query(Doctor.class)
                    .optional();
            return doctor.orElse(null);
        } catch (Exception ex) {
            log.error("DoctorRepositoryImpl => getDoctorById: {}", ex.getMessage());
            return null;
        }
    }

    @Override
    public Integer updateDoctor(String id, Doctor doctor) {
        try {
            var sql = "UPDATE doctor SET doctor_name = ?, doctor_specialization = ? WHERE doctor_id = ?";
            return jdbcClient.sql(sql)
                    .param(1, doctor.getDoctorName())
                    .param(2, doctor.getDoctorSpecialization())
                    .param(3, id)
                    .update();
        } catch (Exception ex) {
            log.error("DoctorRepositoryImpl => updateDoctor: {}", ex.getMessage());
            return 0;
        }
    }

    @Override
    public Integer deleteDoctor(String id) {
        try {
            var sql = "DELETE FROM doctor WHERE doctor_id = ?";
            return jdbcClient.sql(sql)
                    .param(1, id)
                    .update();
        } catch (Exception ex) {
            log.error("DoctorRepositoryImpl => deleteDoctor: {}", ex.getMessage());
            return 0;
        }
    }
}
