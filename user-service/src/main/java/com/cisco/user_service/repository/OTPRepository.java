package com.cisco.user_service.repository;

import com.cisco.user_service.dto.OTPRequestDTO;

public interface OTPRepository {
    String saveOTP(OTPRequestDTO otpRequestDTO);
}
