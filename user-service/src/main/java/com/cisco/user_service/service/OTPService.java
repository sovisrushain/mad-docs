package com.cisco.user_service.service;

import com.cisco.user_service.dto.OTPRequestDTO;
import com.cisco.user_service.dto.OTPValidateDTO;

public interface OTPService {
    String createOTP(OTPRequestDTO otpRequestDTO);
    boolean validateOTP(OTPValidateDTO otpValidateDTO);
}
