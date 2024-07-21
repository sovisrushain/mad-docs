package com.cisco.doctor_schedule_service.service.impl;

import com.cisco.doctor_schedule_service.dto.FullDoctorScheduleDetail;
import com.cisco.doctor_schedule_service.dto.ResponseDTO;
import com.cisco.doctor_schedule_service.model.Doctor;
import com.cisco.doctor_schedule_service.model.DoctorSchedule;
import com.cisco.doctor_schedule_service.model.Hospital;
import com.cisco.doctor_schedule_service.repository.DoctorScheduleRepository;
import com.cisco.doctor_schedule_service.service.DoctorScheduleService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorScheduleServiceImpl implements DoctorScheduleService {

    private static final Logger log = LoggerFactory.getLogger(DoctorScheduleServiceImpl.class);
    private final WebClient.Builder webClientBuilder;
    private final ObjectMapper objectMapper;
    private final DoctorScheduleRepository doctorScheduleRepository;
    @Value("${doctor.service.api}")
    private String doctorScheduleUrl;
    @Value("${hospital.service.api}")
    private String hospitalScheduleUrl;

    @Override
    public String createDoctorSchedule(DoctorSchedule doctorSchedule) {

        var doctorResponse = webClientBuilder.build()
                .get()
                .uri(doctorScheduleUrl + doctorSchedule.getDoctorId())
                .retrieve()
                .bodyToMono(ResponseDTO.class)
                .block();
        if (doctorResponse != null && doctorResponse.getMessage().equals("doctor not found")) {
            log.error("DoctorScheduleServiceImpl => createDoctorSchedule => Doctor Not Found, First Register the Doctor");
            return "Doctor Not Found, First Register the Doctor";
        }

        var hospitalResponse = webClientBuilder.build()
                .get()
                .uri(hospitalScheduleUrl + doctorSchedule.getHospitalId())
                .retrieve()
                .bodyToMono(ResponseDTO.class)
                .block();
        if (hospitalResponse != null && hospitalResponse.getMessage().equals("hospital not found")) {
            log.error("DoctorScheduleServiceImpl => createDoctorSchedule => Hospital Not Found, First Register the Hospital");
            return "Hospital Not Found, First Register the Hospital";
        }

        Integer update = doctorScheduleRepository.createDoctorSchedule(doctorSchedule);
        return (update == 1) ? "Success" : "Failed";

    }

    @Override
    public List<FullDoctorScheduleDetail> getAllDoctorSchedules() {
        List<FullDoctorScheduleDetail> fullDoctorScheduleDetails = new ArrayList<>();
        List<DoctorSchedule> allDoctorSchedules = doctorScheduleRepository.getAllDoctorSchedules();

        allDoctorSchedules.parallelStream().forEach(doctorSchedule -> {
            Doctor doctor = null;
            Hospital hospital = null;

            var doctorResponse = webClientBuilder.build()
                    .get()
                    .uri(doctorScheduleUrl + doctorSchedule.getDoctorId())
                    .retrieve()
                    .bodyToMono(ResponseDTO.class)
                    .block();
            if (doctorResponse != null && doctorResponse.getMessage().equals("doctor not found")) {
                log.error("DoctorScheduleServiceImpl => getAllDoctorSchedules => Doctor Not Found, First Register the Doctor");
            }

            var hospitalResponse = webClientBuilder.build()
                    .get()
                    .uri(hospitalScheduleUrl + doctorSchedule.getHospitalId())
                    .retrieve()
                    .bodyToMono(ResponseDTO.class)
                    .block();
            if (hospitalResponse != null && hospitalResponse.getMessage().equals("hospital not found")) {
                log.error("DoctorScheduleServiceImpl => getAllDoctorSchedules => Hospital Not Found, First Register the Hospital");
            }

            try {
                String doctorJson = objectMapper.writeValueAsString(doctorResponse.getData());
                doctor = objectMapper.readValue(doctorJson, Doctor.class);
                String hospitalJson = objectMapper.writeValueAsString(hospitalResponse.getData());
                hospital = objectMapper.readValue(hospitalJson, Hospital.class);
            } catch (JsonProcessingException e) {
                log.error("DoctorScheduleServiceImpl => getAllDoctorSchedules => JsonProcessingException");
            }

            FullDoctorScheduleDetail fullDoctorScheduleDetail = getFullDoctorScheduleDetail(doctorSchedule, doctor, hospital);
            fullDoctorScheduleDetails.add(fullDoctorScheduleDetail);
        });

        return fullDoctorScheduleDetails;
    }

    private FullDoctorScheduleDetail getFullDoctorScheduleDetail(DoctorSchedule doctorSchedule, Doctor doctor, Hospital hospital) {
        FullDoctorScheduleDetail fullDoctorScheduleDetail = new FullDoctorScheduleDetail();
        fullDoctorScheduleDetail.setScheduleId(doctorSchedule.getScheduleId());
        fullDoctorScheduleDetail.setDoctor(doctor);
        fullDoctorScheduleDetail.setHospital(hospital);
        fullDoctorScheduleDetail.setStartTime(doctorSchedule.getStartTime());
        fullDoctorScheduleDetail.setDayOfWeek(doctorSchedule.getDayOfWeek());
        fullDoctorScheduleDetail.setMaxPatients(doctorSchedule.getMaxPatients());
        return fullDoctorScheduleDetail;
    }
}
