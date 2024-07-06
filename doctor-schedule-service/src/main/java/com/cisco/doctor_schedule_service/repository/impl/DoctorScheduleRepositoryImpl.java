package com.cisco.doctor_schedule_service.repository.impl;

import com.cisco.doctor_schedule_service.model.DoctorSchedule;
import com.cisco.doctor_schedule_service.repository.DoctorScheduleRepository;
import org.springframework.stereotype.Repository;

@Repository
public class DoctorScheduleRepositoryImpl implements DoctorScheduleRepository {
    @Override
    public void createDoctorSchedule(DoctorSchedule doctorSchedule) {
        //todo: save doctor schedule
    }
}
