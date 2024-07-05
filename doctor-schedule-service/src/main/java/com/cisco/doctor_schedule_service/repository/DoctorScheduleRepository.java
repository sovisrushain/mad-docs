package com.cisco.doctor_schedule_service.repository;

import com.cisco.doctor_schedule_service.model.DoctorSchedule;

public interface DoctorScheduleRepository {
    void createDoctorSchedule(DoctorSchedule doctorSchedule);
}
