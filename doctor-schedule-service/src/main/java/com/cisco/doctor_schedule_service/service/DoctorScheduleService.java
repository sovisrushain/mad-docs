package com.cisco.doctor_schedule_service.service;

import com.cisco.doctor_schedule_service.dto.DoctorScheduleDTO;

public interface DoctorScheduleService {
    void createDoctorSchedule(DoctorScheduleDTO doctorScheduleDTO);
}
