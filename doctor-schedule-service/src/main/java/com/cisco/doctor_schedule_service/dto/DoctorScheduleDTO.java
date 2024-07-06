package com.cisco.doctor_schedule_service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DoctorScheduleDTO implements Serializable {
    @NotNull(message = "Schedule ID can not be null")
    @Pattern(regexp = "^S\\d{3}$", message = "Wrong Schedule ID format")
    private String scheduleId;
    @NotNull(message = "Doctor can not be null")
    private Doctor doctor;
    @NotNull(message = "Hospital can not be null")
    private Hospital hospital;
    @NotNull(message = "Day can not be null")
    @NotBlank(message = "Day cannot be blank")
    private String dayOfWeek;
    @NotNull(message = "Time can not be null")
    @NotBlank(message = "Time cannot be blank")
    private String startTime;
    @NotNull(message = "Max Patients can not be null")
    @NotBlank(message = "Max Patients cannot be blank")
    private Integer maxPatients;
}
