package com.cisco.doctor_service.utl;

import com.cisco.doctor_service.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;

import java.util.List;

public class ValidationHandler {

    private ValidationHandler() {}

    public static ResponseDTO<Integer> handleValidation(BindingResult bindingResult, ResponseDTO<Integer> responseDTO) {
            List<String> errors = bindingResult.getFieldErrors().stream()
                    .map(err -> err.getField() + ": " + err.getDefaultMessage())
                    .toList();
            responseDTO.setMessage(errors.getFirst());
            responseDTO.setStatusCode(HttpStatus.BAD_REQUEST);
            return responseDTO;
    }
}
