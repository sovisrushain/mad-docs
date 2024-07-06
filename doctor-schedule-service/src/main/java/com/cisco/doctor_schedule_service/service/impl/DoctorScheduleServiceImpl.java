package com.cisco.doctor_schedule_service.service.impl;

import com.cisco.doctor_schedule_service.model.DoctorSchedule;
import com.cisco.doctor_schedule_service.repository.DoctorScheduleRepository;
import com.cisco.doctor_schedule_service.service.DoctorScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DoctorScheduleServiceImpl implements DoctorScheduleService {

    private final DoctorScheduleRepository doctorScheduleRepository;

    @Override
    public String createDoctorSchedule(DoctorSchedule doctorSchedule) {
        doctorScheduleRepository.createDoctorSchedule(doctorSchedule);
        return null;
    }
}
