package com.cisco.hospital_service.repository;

import com.cisco.hospital_service.model.Hospital;

import java.util.List;

public interface HospitalRepository {
    Integer addHospital(Hospital hospital);
    List<Hospital> getAllHospitals();
    Integer getHospitalsCount();
    Hospital getHospitalById(Integer id);
    Integer updateHospital(Hospital hospital);
    Integer deleteHospital(Integer id);
}
