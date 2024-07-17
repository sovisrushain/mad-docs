package com.cisco.doctor_schedule_service.service;

import com.cisco.doctor_schedule_service.dto.FullDoctorScheduleDetail;
import com.cisco.doctor_schedule_service.model.DoctorSchedule;

import java.util.List;

public interface DoctorScheduleService {
    String createDoctorSchedule(DoctorSchedule doctorSchedule);
    List<FullDoctorScheduleDetail> getAllDoctorSchedules();
}
