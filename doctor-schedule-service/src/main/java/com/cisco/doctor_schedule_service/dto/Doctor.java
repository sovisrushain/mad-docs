package com.cisco.doctor_schedule_service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {
    @NotNull(message = "Doctor ID can not be null")
    @Pattern(regexp = "^D\\d{3}$", message = "Wrong doctor ID format")
    private String doctorId;
    @NotNull(message = "Doctor name can not be null")
    @NotBlank(message = "Doctor name cannot be blank")
    private String doctorName;
    @NotNull(message = "Doctor address can not be null")
    @NotBlank(message = "Doctor address cannot be blank")
    private String doctorSpecialization;
}
