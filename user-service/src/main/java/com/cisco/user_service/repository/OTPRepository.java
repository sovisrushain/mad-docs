package com.cisco.user_service.repository;

import com.cisco.user_service.dto.OTPRequestDTO;

public interface OTPRepository {
    int saveOTP(OTPRequestDTO otpRequestDTO, String otp);
}
