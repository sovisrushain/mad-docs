package com.cisco.doctor_service.controller;

import com.cisco.doctor_service.dto.ResponseDTO;
import com.cisco.doctor_service.model.Doctor;
import com.cisco.doctor_service.service.DoctorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class DoctorControllerTest {

    @InjectMocks
    private DoctorController doctorController;

    @Mock
    private DoctorService doctorService;

    @Mock
    private BindingResult bindingResult;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

//    @Test
//    public void test_Get_All_Doctors() {
//        List<Doctor> doctors = Arrays.asList(new Doctor(), new Doctor());
//        when(doctorService.getAllDoctors()).thenReturn(doctors);
//
//        ResponseDTO<List<Doctor>> response = doctorController.getAllDoctors();
//
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        assertEquals(doctors, response.getData());
//        assertEquals("all doctors", response.getMessage());
//    }
//
//    @Test
//    public void test_Get_All_Doctors_Empty() {
//        when(doctorService.getAllDoctors()).thenReturn(new ArrayList<>());
//
//        ResponseDTO<List<Doctor>> response = doctorController.getAllDoctors();
//
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        assertEquals(0, response.getData().size());
//        assertEquals("there are no doctors registered", response.getMessage());
//    }


}