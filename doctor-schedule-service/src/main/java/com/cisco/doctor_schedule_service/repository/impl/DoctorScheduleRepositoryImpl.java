package com.cisco.doctor_schedule_service.repository.impl;

import com.cisco.doctor_schedule_service.model.DoctorSchedule;
import com.cisco.doctor_schedule_service.repository.DoctorScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class DoctorScheduleRepositoryImpl implements DoctorScheduleRepository {

    private final JdbcClient jdbcClient;
    private static final Logger log = LoggerFactory.getLogger(DoctorScheduleRepositoryImpl.class);

    @Override
    public Integer createDoctorSchedule(DoctorSchedule doctorSchedule) {
        try {
            var sql = "INSERT INTO doctor_schedule(schedule_id, doctor_id, hospital_id, day_of_week, start_time, max_patients) VALUES (?, ?, ?, ?, ?, ?)";
            return jdbcClient.sql(sql)
                    .param(1, doctorSchedule.getScheduleId())
                    .param(2, doctorSchedule.getDoctorId())
                    .param(3, doctorSchedule.getHospitalId())
                    .param(4, doctorSchedule.getDayOfWeek())
                    .param(5, doctorSchedule.getStartTime())
                    .param(6, doctorSchedule.getMaxPatients())
                    .update();
        } catch (Exception ex) {
            log.error("DoctorScheduleRepositoryImpl => createDoctorSchedule: {}", ex.getMessage());
            return 0;
        }
    }

    @Override
    public List<DoctorSchedule> getAllDoctorSchedules() {
        return List.of();
    }
}
