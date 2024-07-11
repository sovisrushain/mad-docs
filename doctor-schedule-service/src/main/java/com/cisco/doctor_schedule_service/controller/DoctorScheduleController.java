package com.cisco.doctor_schedule_service.controller;

import com.cisco.doctor_schedule_service.dto.ResponseDTO;
import com.cisco.doctor_schedule_service.model.DoctorSchedule;
import com.cisco.doctor_schedule_service.service.DoctorScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/schedule")
@RequiredArgsConstructor
public class DoctorScheduleController {

    private final DoctorScheduleService doctorScheduleService;

    @GetMapping
    public ResponseDTO<List<DoctorSchedule>> getAllDoctorSchedules() {
        ResponseDTO<List<DoctorSchedule>> responseDTO = new ResponseDTO<>();
        doctorScheduleService.getAllDoctorSchedules();
        return responseDTO;
    }

    @PostMapping
    public ResponseDTO<String> createDoctorSchedule(@RequestBody DoctorSchedule doctorSchedule) {
        ResponseDTO<String> responseDTO = new ResponseDTO<>();
        String res = doctorScheduleService.createDoctorSchedule(doctorSchedule);
        if (res.equals("Success")) {
            responseDTO.setMessage("success");
            responseDTO.setData(res);
            responseDTO.setStatusCode(HttpStatus.CREATED);
        } else {
            responseDTO.setMessage(res);
            responseDTO.setData(res);
            responseDTO.setStatusCode(HttpStatus.BAD_REQUEST);
        }
        return responseDTO;
    }
}
