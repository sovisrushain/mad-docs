package com.cisco.hospital_service.util;

import com.cisco.hospital_service.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;

import java.util.List;

public class ValidationHandler {
    public static ResponseDTO<Integer> handleValidation(BindingResult bindingResult, ResponseDTO<Integer> responseDTO) {
            List<String> errors = bindingResult.getFieldErrors().stream()
                    .map(err -> err.getField() + ": " + err.getDefaultMessage())
                    .toList();
            responseDTO.setMessage(errors.getFirst());
            responseDTO.setStatusCode(HttpStatus.BAD_REQUEST);
            return responseDTO;
    }
}