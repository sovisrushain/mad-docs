package com.cisco.hospital_service.service;

import com.cisco.hospital_service.model.Hospital;

import java.util.List;

public interface HospitalService {
    Integer addHospital(Hospital hospital);
    List<Hospital> getAllHospitals();
    Integer getHospitalsCount();
    Hospital getHospitalById(String id);
    Integer updateHospital(String id, Hospital hospital);
    Integer deleteHospital(String id);
}
