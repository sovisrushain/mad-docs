package com.cisco.doctor_schedule_service.controller;

import com.cisco.doctor_schedule_service.dto.DoctorScheduleDTO;
import com.cisco.doctor_schedule_service.model.DoctorSchedule;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/schedule")
@RequiredArgsConstructor
public class DoctorScheduleController {

    @PostMapping
    public void createDoctorSchedule(@RequestBody DoctorScheduleDTO doctorScheduleDTO) {

    }
}
