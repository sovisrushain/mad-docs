package com.cisco.doctor_schedule_service.dto;

import com.cisco.doctor_schedule_service.model.Doctor;
import com.cisco.doctor_schedule_service.model.Hospital;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FullDoctorScheduleDetail {
    private String scheduleId;
    private Doctor doctor;
    private Hospital hospital;
    private String dayOfWeek;
    private String startTime;
    private Integer maxPatients;
}
