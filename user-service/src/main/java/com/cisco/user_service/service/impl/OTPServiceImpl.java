package com.cisco.user_service.service.impl;

import com.cisco.user_service.dto.OTPRequestDTO;
import com.cisco.user_service.service.OTPService;
import org.springframework.stereotype.Service;

@Service
public class OTPServiceImpl implements OTPService {
    @Override
    public String createOTP(OTPRequestDTO otpRequestDTO) {
        return "";
    }

    @Override
    public String validateOTP(OTPRequestDTO otpRequestDTO) {
        return "";
    }
}
