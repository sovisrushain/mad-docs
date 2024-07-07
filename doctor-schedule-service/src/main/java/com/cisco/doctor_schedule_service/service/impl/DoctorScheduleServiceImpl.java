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
        //todo:  call doctor service & check doctor is present
        //todo: if not return asking register the doctor first

        //todo:  call hospital service & check doctor is present
        //todo: if not return asking register the hospital first

        //todo: both doc and hospital are present save the schedule
        Integer update = doctorScheduleRepository.createDoctorSchedule(doctorSchedule);
        return (update == 1) ? "Success" : "Failed";

    }
}
