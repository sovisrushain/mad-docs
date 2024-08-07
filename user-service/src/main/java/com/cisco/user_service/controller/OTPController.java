package com.cisco.user_service.controller;

import com.cisco.user_service.dto.OTPCreateDTO;
import com.cisco.user_service.dto.OTPValidateDTO;
import com.cisco.user_service.service.OTPService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/otp")
@RequiredArgsConstructor
public class OTPController {

    private final OTPService otpService;

    @PostMapping("/create")
    public String createOTP(@RequestBody OTPCreateDTO otpCreateDTO) {
        return otpService.createOTP(otpCreateDTO);
    }

    @PostMapping("/validate")
    public Boolean validateOTP(@RequestBody OTPValidateDTO otpValidateDTO) {
        return otpService.validateOTP(otpValidateDTO);
    }
}
