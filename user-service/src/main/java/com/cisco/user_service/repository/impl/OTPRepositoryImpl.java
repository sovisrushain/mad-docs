package com.cisco.user_service.repository.impl;

import com.cisco.user_service.dto.OTPRequestDTO;
import com.cisco.user_service.repository.OTPRepository;
import org.springframework.stereotype.Repository;

@Repository
public class OTPRepositoryImpl implements OTPRepository {
    @Override
    public String saveOTP(OTPRequestDTO otpRequestDTO) {
        return "";
    }
}
