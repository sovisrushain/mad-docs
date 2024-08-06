package com.cisco.user_service.repository.impl;

import com.cisco.user_service.dto.OTPRequestDTO;
import com.cisco.user_service.repository.OTPRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OTPRepositoryImpl implements OTPRepository {

    private final JdbcClient jdbcClient;
    private static final Logger log = LoggerFactory.getLogger(OTPRepositoryImpl.class);

    @Override
    public int saveOTP(OTPRequestDTO otpRequestDTO, String otp) {
        try {
            var sql = "INSERT INTO otp_table (user_id, mobile_no, otp) VALUES (?, ?, ?);";
            return jdbcClient.sql(sql)
                    .param(1, otpRequestDTO.getUserId())
                    .param(2, otpRequestDTO.getMobileNo())
                    .param(3, otp)
                    .update();
        } catch (Exception ex) {
            log.error("OTPRepositoryImpl => saveOTP: {}", ex.getMessage());
            return 0;
        }
    }
}
