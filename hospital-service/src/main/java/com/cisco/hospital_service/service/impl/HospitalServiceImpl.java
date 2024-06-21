package com.cisco.hospital_service.service.impl;

import com.cisco.hospital_service.model.Hospital;
import com.cisco.hospital_service.repository.HospitalRepository;
import com.cisco.hospital_service.service.HospitalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HospitalServiceImpl implements HospitalService {

    private final HospitalRepository hospitalRepository;

    @Override
    public Integer addHospital(Hospital hospital) {
        return hospitalRepository.addHospital(hospital);
    }

    @Override
    public List<Hospital> getAllHospitals() {
        return hospitalRepository.getAllHospitals();
    }

    @Override
    public Integer getHospitalsCount() {
        return hospitalRepository.getHospitalsCount();
    }

    @Override
    public Hospital getHospitalById(String id) {
        return hospitalRepository.getHospitalById(id);
    }

    @Override
    public Integer updateHospital(String id, Hospital hospital) {
        return hospitalRepository.updateHospital(id, hospital);
    }

    @Override
    public Integer deleteHospital(String id) {
        return hospitalRepository.deleteHospital(id);
    }
}
