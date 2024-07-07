package com.cisco.doctor_schedule_service.controller;

import com.cisco.doctor_schedule_service.dto.ResponseDTO;
import com.cisco.doctor_schedule_service.model.DoctorSchedule;
import com.cisco.doctor_schedule_service.service.DoctorScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/schedule")
@RequiredArgsConstructor
public class DoctorScheduleController {

    private final DoctorScheduleService doctorScheduleService;

    @PostMapping
    public ResponseDTO<String> createDoctorSchedule(@RequestBody DoctorSchedule doctorSchedule) {
        ResponseDTO<String> responseDTO = new ResponseDTO<>();
        String res = doctorScheduleService.createDoctorSchedule(doctorSchedule);
        if (res.equals("success")) {
            responseDTO.setMessage("success");
            responseDTO.setData(res);
            responseDTO.setStatusCode(HttpStatus.CREATED);
        } else {
            responseDTO.setMessage(res);
            responseDTO.setData(res);
            responseDTO.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseDTO;
    }
}
