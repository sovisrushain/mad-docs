package com.cisco.user_service.service;

import com.cisco.user_service.dto.OTPCreateDTO;
import com.cisco.user_service.dto.OTPValidateDTO;

public interface OTPService {
    String createOTP(OTPCreateDTO otpCreateDTO);
    boolean validateOTP(OTPValidateDTO otpValidateDTO);
}
