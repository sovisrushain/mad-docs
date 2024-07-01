package com.cisco.doctor_schedule_service.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DoctorSchedule implements Serializable {
    private String scheduleId;
    private String doctorId;
    private String hospitalId;
    private String dayOfWeek;
    private String startTime;
    private Integer maxPatients;
}
