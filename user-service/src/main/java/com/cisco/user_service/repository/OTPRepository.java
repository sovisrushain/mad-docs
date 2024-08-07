package com.cisco.user_service.repository;

import com.cisco.user_service.dto.OTPCreateDTO;
import com.cisco.user_service.dto.OTPValidateDTO;

public interface OTPRepository {
    int saveOTP(OTPCreateDTO otpCreateDTO, String otp);
    boolean validateOTP(OTPValidateDTO otpValidateDTO);
}
