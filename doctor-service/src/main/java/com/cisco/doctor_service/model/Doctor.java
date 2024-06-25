package com.cisco.doctor_service.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {
    private String doctorId;
    private String doctorName;
    private String doctorSpecialization;
}
