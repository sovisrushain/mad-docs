package com.cisco.hospital_service.controller;

import com.cisco.hospital_service.dto.ResponseDTO;
import com.cisco.hospital_service.model.Hospital;
import com.cisco.hospital_service.service.HospitalService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class HospitalControllerTest {

    @Mock
    private HospitalService hospitalService;

    @InjectMocks
    private HospitalController hospitalController;

    @BeforeEach
    void setUp() {
        hospitalController = new HospitalController(hospitalService);
    }

    @Test
    void test_get_all_hospitals_no_hospitals() {
        when(hospitalService.getAllHospitals()).thenReturn(Collections.emptyList());
        ResponseDTO<List<Hospital>> response = hospitalController.getAllHospitals();

        assertNotNull(response);
        assertTrue(response.getData().isEmpty());
        assertEquals("there are no hospitals registered", response.getMessage());
        assertEquals(HttpStatus.OK, response.getStatusCode());

        verify(hospitalService, times(1)).getAllHospitals();
    }

//    @Test
//    void getHospitalById() {
//    }
//
//    @Test
//    void createHospital() {
//    }
//
//    @Test
//    void updateHospital() {
//    }
//
//    @Test
//    void deleteHospital() {
//    }
//
//    @Test
//    void getHospitalCount() {
//    }
}