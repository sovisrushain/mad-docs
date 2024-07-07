package com.cisco.doctor_schedule_service.service.impl;

import com.cisco.doctor_schedule_service.model.Doctor;
import com.cisco.doctor_schedule_service.model.DoctorSchedule;
import com.cisco.doctor_schedule_service.model.Hospital;
import com.cisco.doctor_schedule_service.repository.DoctorScheduleRepository;
import com.cisco.doctor_schedule_service.service.DoctorScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class DoctorScheduleServiceImpl implements DoctorScheduleService {

    private final DoctorScheduleRepository doctorScheduleRepository;
    private final WebClient.Builder webClientBuilder;

    @Override
    public String createDoctorSchedule(DoctorSchedule doctorSchedule) {

        Doctor doctor = webClientBuilder.build()
                .get()
                .uri("{}" + doctorSchedule.getDoctorId())
                .retrieve()
                .bodyToMono(Doctor.class)
                .block();
        if (doctor == null) {
            return "Doctor Not Found, First Register the Doctor";
        }

        Hospital hospital = webClientBuilder.build()
                .get()
                .uri("{}" + doctorSchedule.getHospitalId())
                .retrieve()
                .bodyToMono(Hospital.class)
                .block();
        if (hospital == null) {
            return "Hospital Not Found, First Register the Hospital";
        }

        Integer update = doctorScheduleRepository.createDoctorSchedule(doctorSchedule);
        return (update == 1) ? "Success" : "Failed";

    }
}
