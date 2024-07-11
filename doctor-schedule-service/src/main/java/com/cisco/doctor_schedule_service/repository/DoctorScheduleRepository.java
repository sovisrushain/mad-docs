package com.cisco.doctor_schedule_service.repository;

import com.cisco.doctor_schedule_service.model.DoctorSchedule;

import java.util.List;

public interface DoctorScheduleRepository {
    Integer createDoctorSchedule(DoctorSchedule doctorSchedule);
    List<DoctorSchedule> getAllDoctorSchedules();
}
