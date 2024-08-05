package com.cisco.user_service.controller;

import com.cisco.user_service.dto.OTPRequestDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @PostMapping("/create-otp")
    public String createOTP(@RequestBody OTPRequestDTO otpRequestDTO) {
        return null;
    }

    @PostMapping("validate-otp")
    public String validateOTP(@RequestBody OTPRequestDTO otpRequestDTO) {
        return null;
    }
}
