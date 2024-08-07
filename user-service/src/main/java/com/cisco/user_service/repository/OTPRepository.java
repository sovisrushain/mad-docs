package com.cisco.user_service.repository;

import com.cisco.user_service.dto.OTPRequestDTO;
import com.cisco.user_service.dto.OTPValidateDTO;

public interface OTPRepository {
    int saveOTP(OTPRequestDTO otpRequestDTO, String otp);
    int validateOTP(OTPValidateDTO otpValidateDTO);
}
