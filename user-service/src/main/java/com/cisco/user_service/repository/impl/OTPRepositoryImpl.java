package com.cisco.user_service.repository.impl;

import com.cisco.user_service.dto.OTPCreateDTO;
import com.cisco.user_service.dto.OTPValidateDTO;
import com.cisco.user_service.repository.OTPRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OTPRepositoryImpl implements OTPRepository {

    private final JdbcClient jdbcClient;
    private final JdbcTemplate jdbcTemplate;
    private static final Logger log = LoggerFactory.getLogger(OTPRepositoryImpl.class);

    @Override
    public int saveOTP(OTPCreateDTO otpCreateDTO, String otp) {
        try {
            var sql = "INSERT INTO otp_table (user_id, mobile_no, otp) VALUES (?, ?, ?);";
            return jdbcClient.sql(sql)
                    .param(1, otpCreateDTO.getUserId())
                    .param(2, otpCreateDTO.getMobileNo())
                    .param(3, otp)
                    .update();
        } catch (Exception ex) {
            log.error("OTPRepositoryImpl => saveOTP: {}", ex.getMessage());
            return 0;
        }
    }

    @Override
    public boolean validateOTP(OTPValidateDTO otpValidateDTO) {
        try {
            var sql ="SELECT EXISTS (SELECT 1 FROM otp_table WHERE otp = ? AND mobile_no = ?);";
            return Boolean.TRUE.equals(jdbcTemplate.queryForObject(sql,
                    new Object[]{otpValidateDTO.getOtp(), otpValidateDTO.getMobileNo()},
                    Boolean.class));
        } catch (Exception ex) {
            log.error("OTPRepositoryImpl => validateOTP: {}", ex.getMessage());
            return false;
        }
    }
}
