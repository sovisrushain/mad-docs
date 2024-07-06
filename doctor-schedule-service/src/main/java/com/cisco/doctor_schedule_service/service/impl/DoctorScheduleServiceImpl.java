package com.cisco.doctor_schedule_service.service.impl;

import com.cisco.doctor_schedule_service.dto.DoctorScheduleDTO;
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
    public void createDoctorSchedule(DoctorScheduleDTO doctorScheduleDTO) {
        DoctorSchedule doctorSchedule = new DoctorSchedule();
        doctorScheduleRepository.createDoctorSchedule(doctorSchedule);
    }
}
