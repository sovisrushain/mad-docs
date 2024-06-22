package com.cisco.hospital_service.repository.impl;

import com.cisco.hospital_service.model.Hospital;
import com.cisco.hospital_service.repository.HospitalRepository;
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
public class HospitalRepositoryImpl implements HospitalRepository {

    private static final Logger log = LoggerFactory.getLogger(HospitalRepositoryImpl.class);
    private final JdbcClient jdbcClient;

    public Integer addHospital(Hospital hospital) {
        try {
            var sql = "INSERT INTO hospital(hospital_id, hospital_name, hospital_address) VALUES (?, ?, ?)";
            return jdbcClient.sql(sql)
                    .param(1, hospital.getHospitalId())
                    .param(2, hospital.getHospitalName())
                    .param(3, hospital.getHospitalAddress())
                    .update();
        } catch (Exception ex) {
            log.error("HospitalRepositoryImpl => addHospital: {}", ex.getMessage());
            return 0;
        }
    }

    public List<Hospital> getAllHospitals() {
        try {
            var sql = "SELECT * FROM hospital";
            return jdbcClient.sql(sql)
                    .query(Hospital.class)
                    .list();
        } catch (Exception ex) {
            log.error("HospitalRepositoryImpl => getAllHospitals: {}", ex.getMessage());
            return new ArrayList<>();
        }
    }

    public Integer getHospitalsCount() {
        var sql = "SELECT COUNT(*) FROM hospital";
        Optional<Integer> count = jdbcClient.sql(sql)
                .query(Integer.class)
                .optional();
        return count.orElse(0);
    }

    public Hospital getHospitalById(String id) {
        try {
            var sql = "SELECT * FROM hospital WHERE hospital_id = ?";
            Optional<Hospital> hospital = jdbcClient.sql(sql)
                    .param(1, id)
                    .query(Hospital.class)
                    .optional();
            return hospital.orElse(null);
        } catch (Exception ex) {
            log.error("HospitalRepositoryImpl => getHospitalById: {}", ex.getMessage());
            return null;
        }
    }

    public Integer updateHospital(String id, Hospital hospital) {
        try {
            var sql = "UPDATE hospital SET hospital_name = ?, hospital_address = ? WHERE hospital_id = ?";
            return jdbcClient.sql(sql)
                    .param(1, hospital.getHospitalName())
                    .param(2, hospital.getHospitalAddress())
                    .param(3, id)
                    .update();
        } catch (Exception ex) {
            log.error("HospitalRepositoryImpl => updateHospital: {}", ex.getMessage());
            return 0;
        }
    }

    public Integer deleteHospital(String id) {
        try {
            var sql = "DELETE FROM hospital WHERE hospital_id = ?";
            return jdbcClient.sql(sql)
                    .param(1, id)
                    .update();
        } catch (Exception ex) {
            log.error("HospitalRepositoryImpl => deleteHospital: {}", ex.getMessage());
            return 0;
        }
    }

}
