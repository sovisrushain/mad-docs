package com.cisco.hospital_service.repository.impl;

import com.cisco.hospital_service.model.Hospital;
import com.cisco.hospital_service.repository.HospitalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class HospitalRepositoryImpl implements HospitalRepository {

    private final JdbcClient jdbcClient;

    public Integer addHospital(Hospital hospital) {
        return null;
    }

    public List<Hospital> getAllHospitals() {
        return null;
    }

    public Integer getHospitalsCount() {
        return null;
    }

    public Hospital getHospitalById(Integer id) {
        return null;
    }

    public Integer updateHospital(Hospital hospital) {
        return null;
    }

    public Integer deleteHospital(Integer id) {
        return null;
    }

}
