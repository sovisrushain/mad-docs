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
        return 0;
    }

    @Override
    public List<Hospital> getAllHospitals() {
        return List.of();
    }

    @Override
    public Integer getHospitalsCount() {
        return 0;
    }

    @Override
    public Hospital getHospitalById(Integer id) {
        return null;
    }

    @Override
    public Integer updateHospital(Hospital hospital) {
        return 0;
    }

    @Override
    public Integer deleteHospital(Integer id) {
        return 0;
    }
}
