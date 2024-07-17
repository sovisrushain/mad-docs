package com.cisco.doctor_schedule_service.service.impl;

import com.cisco.doctor_schedule_service.dto.FullDoctorScheduleDetail;
import com.cisco.doctor_schedule_service.dto.ResponseDTO;
import com.cisco.doctor_schedule_service.model.Doctor;
import com.cisco.doctor_schedule_service.model.DoctorSchedule;
import com.cisco.doctor_schedule_service.model.Hospital;
import com.cisco.doctor_schedule_service.repository.DoctorScheduleRepository;
import com.cisco.doctor_schedule_service.service.DoctorScheduleService;
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

    @Value("${doctor.service.api}")
    private String doctorScheduleUrl;

    @Value("${hospital.service.api}")
    private String hospitalScheduleUrl;

    private final WebClient.Builder webClientBuilder;
    private final DoctorScheduleRepository doctorScheduleRepository;
    private static final Logger log = LoggerFactory.getLogger(DoctorScheduleServiceImpl.class);


    @Override
    public String createDoctorSchedule(DoctorSchedule doctorSchedule) {

        var doctorResponse = webClientBuilder.build()
                .get()
                .uri(doctorScheduleUrl + doctorSchedule.getDoctorId())
                .retrieve()
                .bodyToMono(ResponseDTO.class)
                .block();
        if (doctorResponse.getMessage().equals("doctor not found")) {
            log.error("DoctorScheduleServiceImpl => createDoctorSchedule => Doctor Not Found, First Register the Doctor");
            return "Doctor Not Found, First Register the Doctor";
        }

        var hospitalResponse = webClientBuilder.build()
                .get()
                .uri(hospitalScheduleUrl + doctorSchedule.getHospitalId())
                .retrieve()
                .bodyToMono(ResponseDTO.class)
                .block();
        if (hospitalResponse.getMessage().equals("hospital not found")) {
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
            String doctorId = doctorSchedule.getDoctorId();
            String hospitalId = doctorSchedule.getHospitalId();
            //todo: get doctor detail
            //todo: get hospital detail
            //todo: aggrigate and send response
            FullDoctorScheduleDetail fullDoctorScheduleDetail = new FullDoctorScheduleDetail();
            fullDoctorScheduleDetail.setScheduleId(doctorSchedule.getScheduleId());
            fullDoctorScheduleDetail.setDoctor(null);
            fullDoctorScheduleDetail.setHospital(null);
            fullDoctorScheduleDetail.setStartTime(doctorSchedule.getStartTime());
            fullDoctorScheduleDetail.setDayOfWeek(doctorSchedule.getDayOfWeek());
            fullDoctorScheduleDetail.setMaxPatients(doctorSchedule.getMaxPatients());
            fullDoctorScheduleDetails.add(fullDoctorScheduleDetail);
        });
        return fullDoctorScheduleDetails;
    }
}
