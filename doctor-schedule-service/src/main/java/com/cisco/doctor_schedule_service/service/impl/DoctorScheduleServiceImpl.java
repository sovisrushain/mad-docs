package com.cisco.doctor_schedule_service.service.impl;

import com.cisco.doctor_schedule_service.model.Doctor;
import com.cisco.doctor_schedule_service.model.DoctorSchedule;
import com.cisco.doctor_schedule_service.model.Hospital;
import com.cisco.doctor_schedule_service.repository.DoctorScheduleRepository;
import com.cisco.doctor_schedule_service.service.DoctorScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class DoctorScheduleServiceImpl implements DoctorScheduleService {

    @Value("${doctor.service.api}")
    private String doctorScheduleUrl;

    @Value("${hospital.service.api}")
    private String hospitalScheduleUrl;

    private final WebClient.Builder webClientBuilder;
    private final DoctorScheduleRepository doctorScheduleRepository;

    @Override
    public String createDoctorSchedule(DoctorSchedule doctorSchedule) {

        Doctor doctor = webClientBuilder.build()
                .get()
                .uri(doctorScheduleUrl + doctorSchedule.getDoctorId())
                .retrieve()
                .bodyToMono(Doctor.class)
                .block();
        if (doctor == null) {
            return "Doctor Not Found, First Register the Doctor";
        }

        Hospital hospital = webClientBuilder.build()
                .get()
                .uri(hospitalScheduleUrl + doctorSchedule.getHospitalId())
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
