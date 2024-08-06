package com.cisco.user_service.service.impl;

import com.cisco.user_service.dto.OTPRequestDTO;
import com.cisco.user_service.service.OTPService;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;

@Service
public class OTPServiceImpl implements OTPService {
    @Override
    public String createOTP(OTPRequestDTO otpRequestDTO) {
        String otp = generateOTP();
        // save otp in backend
        return "";
    }

    @Override
    public String validateOTP(OTPRequestDTO otpRequestDTO) {
        return "";
    }

    private String generateOTP() {
        SecureRandom random = new SecureRandom();
        int otp = 100000 + random.nextInt(900000);
        return String.valueOf(otp);
    }
}
