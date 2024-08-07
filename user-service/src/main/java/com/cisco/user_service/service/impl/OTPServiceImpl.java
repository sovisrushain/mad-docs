package com.cisco.user_service.service.impl;

import com.cisco.user_service.dto.OTPCreateDTO;
import com.cisco.user_service.dto.OTPValidateDTO;
import com.cisco.user_service.repository.OTPRepository;
import com.cisco.user_service.service.OTPService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class OTPServiceImpl implements OTPService {

    private final OTPRepository otpRepository;

    @Override
    public String createOTP(OTPCreateDTO otpCreateDTO) {
        var res = 0;
        String otp = generateOTP();

        if (isValidOTP(otp)) {
            res = otpRepository.saveOTP(otpCreateDTO, otp);
        } else {
            return "Failed";
        }

        return res > 0 ? otp : "Failed";
    }

    @Override
    public boolean validateOTP(OTPValidateDTO otpValidateDTO) {
        return otpRepository.validateOTP(otpValidateDTO);
    }

    private String generateOTP() {
        SecureRandom random = new SecureRandom();
        int otp = 100000 + random.nextInt(900000);
        return String.valueOf(otp);
    }

    private boolean isValidOTP(String otp) {
        String regex = "^\\d{6}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(otp);
        return matcher.matches();
    }
}
