package com.cisco.doctor_schedule_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DoctorScheduleDTO {
    private String scheduleId;
    private Doctor doctor;
    private Hospital hospital;
    private String dayOfWeek;
    private String startTime;
    private Integer maxPatients;
}
