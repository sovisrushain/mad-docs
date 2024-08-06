package com.cisco.user_service.service;

import com.cisco.user_service.dto.OTPRequestDTO;

public interface OTPService {
    String createOTP(OTPRequestDTO otpRequestDTO);
    String validateOTP(OTPRequestDTO otpRequestDTO);
}
